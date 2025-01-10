package org.meli.models;

public class Item {
    private String id;
    private String descripcion;
    private double precio;
    private int cantidad;

    // Constructor, getters y setters
    public Item(String id, String descripcion, double precio, int cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return precio * cantidad;
    }
}

