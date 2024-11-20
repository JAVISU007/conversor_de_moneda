package com.conversor.moneda;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Conversor {

    private String apiKey;
    private Map<String, Double> cacheTasas = new HashMap<>();

    public Conversor(String apiKey) {
        this.apiKey = apiKey;
    }

    public double obtenerTasaDeCambio(Moneda monedaOrigen, Moneda monedaDestino) {
        String claveCache = monedaOrigen.getCodigoISO() + "-" + monedaDestino.getCodigoISO();
        if (cacheTasas.containsKey(claveCache)) {
            return cacheTasas.get(claveCache);
        }

        try {
            String url = "https://api.exchangerate-api.com/v4/latest/" + monedaOrigen.getCodigoISO();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
                JsonElement tasaDeCambioElement = jsonObject.get("rates").getAsJsonObject().get(monedaDestino.getCodigoISO());

                if (tasaDeCambioElement != null) {
                    double tasaDeCambio = tasaDeCambioElement.getAsDouble();
                    cacheTasas.put(claveCache, tasaDeCambio);
                    return tasaDeCambio;
                } else {
                    System.err.println("La tasa de cambio para " + monedaDestino.getCodigoISO() + " no está disponible.");
                    return 0.0;
                }
            } else {
                System.err.println("Error al obtener la tasa de cambio: " + response.statusCode());
                System.err.println("Respuesta: " + response.body());
                return 0.0;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0.0;
        }
    }

    public double convertir(double cantidad, Moneda monedaOrigen, Moneda monedaDestino) {
        double tasaDeCambio = obtenerTasaDeCambio(monedaOrigen, monedaDestino);
        return cantidad * tasaDeCambio;
    }
}
