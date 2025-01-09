package com.thiagoschreck.local.model;

public class Producto {
    private final String codigo;
    private final String nombre;
    private final int cantidad;
    private final double costo;

    public Producto(String codigo, String nombre, int cantidad, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public double getTotal() {
        return costo * cantidad;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s x%s - $%s", codigo, nombre, cantidad, costo * cantidad);
    }
}
