package com.bootcamp.model;

public class Personaje {
    private String nombre;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Personaje{nombre='" + nombre + "'}";
    }
}
