package org.meli.models;

public class NoPerecedero extends Producto {
    private String tipo;

    public NoPerecedero(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }
}


