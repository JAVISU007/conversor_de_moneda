package com.conversor.moneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // Crea objetos Moneda
        Moneda dolar = new Moneda("Dólar", "Dólares", "$", "USD");
        Moneda euro = new Moneda("Euro", "Euros", "€", "EUR");
        Moneda pesoColombiano = new Moneda("Peso Colombiano", "Pesos Colombianos", "$", "COP");
        Moneda solPeruano = new Moneda("Sol Peruano", "Soles Peruanos", "S/", "PEN");
        Moneda pesoMexicano = new Moneda("Peso Mexicano", "Pesos Mexicanos", "$", "MXN");
        Moneda realBrasileño = new Moneda("Real Brasileño", "Reales Brasileños", "R$", "BRL");

        // Crea un objeto Conversor con tu API Key
        Conversor conversor = new Conversor("a1ae7ea59038a09d72c3c6b1");

        // Crea un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        double cantidad = 0;
        try {
            // Pide al usuario que ingrese la cantidad a convertir
            System.out.print("Ingresa la cantidad a convertir: ");
            cantidad = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.next(); // Limpia la entrada incorrecta
            return;
        }

        // Pide al usuario que ingrese la moneda de origen
        System.out.print("Ingresa la moneda de origen (USD, EUR, COP, PEN, MXN, BRL): ");
        String codigoOrigen = scanner.next();

        // Pide al usuario que ingrese la moneda de destino
        System.out.print("Ingresa la moneda de destino (USD, EUR, COP, PEN, MXN, BRL): ");
        String codigoDestino = scanner.next();

        if (!codigoValido(codigoOrigen) || !codigoValido(codigoDestino)) {
            System.out.println("Moneda de origen o destino inválida.");
            return;
        }

        // Asigna las monedas de origen y destino
        Moneda monedaOrigen = obtenerMonedaPorCodigo(codigoOrigen, dolar, euro, pesoColombiano, solPeruano, pesoMexicano, realBrasileño);
        Moneda monedaDestino = obtenerMonedaPorCodigo(codigoDestino, dolar, euro, pesoColombiano, solPeruano, pesoMexicano, realBrasileño);

        // Realiza la conversión
        if (monedaOrigen != null && monedaDestino != null) {
            double cantidadConvertida = conversor.convertir(cantidad, monedaOrigen, monedaDestino);
            System.out.println(formatearSalida(cantidad, monedaOrigen) + " equivalen a " + formatearSalida(cantidadConvertida, monedaDestino));
        } else {
            System.out.println("Moneda de origen o destino inválida.");
        }

        scanner.close();
    }

    private static boolean codigoValido(String codigo) {
        return codigo.equalsIgnoreCase("USD") ||
                codigo.equalsIgnoreCase("EUR") ||
                codigo.equalsIgnoreCase("COP") ||
                codigo.equalsIgnoreCase("PEN") ||
                codigo.equalsIgnoreCase("MXN") ||
                codigo.equalsIgnoreCase("BRL");
    }

    private static Moneda obtenerMonedaPorCodigo(String codigo, Moneda... monedas) {
        for (Moneda moneda : monedas) {
            if (moneda.getCodigoISO().equalsIgnoreCase(codigo)) {
                return moneda;
            }
        }
        return null;
    }

    private static String formatearSalida(double cantidad, Moneda moneda) {
        String nombre = (cantidad == 1) ? moneda.getNombre() : moneda.getNombrePlural();
        return cantidad + " " + nombre;
    }
}


