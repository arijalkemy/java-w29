package com.mdaneri;

public class Vehiculo {

    private final String marca;
    private final String modelo;
    private final double costo;

    public Vehiculo(String marca, String modelo, double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", costo=" + costo +
                '}';
    }
}
