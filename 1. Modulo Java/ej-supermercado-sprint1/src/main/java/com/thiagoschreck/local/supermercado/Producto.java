package com.thiagoschreck.local.supermercado;

public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double costo;

    public Producto(String codigo, String nombre, int cantidad, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public double getTotal() {
        return costo * cantidad;
    }
}
