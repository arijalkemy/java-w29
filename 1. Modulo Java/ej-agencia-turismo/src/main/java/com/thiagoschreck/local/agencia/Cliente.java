package com.thiagoschreck.local.agencia;

public class Cliente {
    private final String nombre;
    private final String apellido;
    private final String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return String.format("%s %s - DNI: %s", nombre, apellido, dni);
    }
}
