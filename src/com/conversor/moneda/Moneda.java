package com.conversor.moneda;

public class Moneda {

    private String nombre;
    private String nombrePlural;
    private String simbolo;
    private String codigoISO;

    public Moneda(String nombre, String nombrePlural, String simbolo, String codigoISO) {
        this.nombre = nombre;
        this.nombrePlural = nombrePlural;
        this.simbolo = simbolo;
        this.codigoISO = codigoISO;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombrePlural() {
        return nombrePlural;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    @Override
    public String toString() {
        return nombre + " (" + simbolo + ", " + codigoISO + ")";
    }
}
