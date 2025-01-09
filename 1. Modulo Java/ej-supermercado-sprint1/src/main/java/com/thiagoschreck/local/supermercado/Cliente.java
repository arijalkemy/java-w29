package com.thiagoschreck.local.supermercado;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

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