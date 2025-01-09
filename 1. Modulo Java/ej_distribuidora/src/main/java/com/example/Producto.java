package com.example;

public class Producto {
    private String nombre;

    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Precio: " + precio;
    }

    public double calcular(int cantidadDeProductos) {
        return cantidadDeProductos * precio;
    }
}
