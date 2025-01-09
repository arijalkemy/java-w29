package com.thiagoschreck.local.model;

public class Cliente {
    private final String dni;
    private final String nombre;
    private final String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return String.format("%s %s - DNI: %s", nombre, apellido, dni);
    }
}