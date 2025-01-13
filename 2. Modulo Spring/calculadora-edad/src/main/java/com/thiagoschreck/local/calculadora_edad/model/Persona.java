package com.thiagoschreck.local.calculadora_edad.model;

public record Persona(int id, FechaDeNacimiento fechaDeNacimiento) {
    public record FechaDeNacimiento(int day, int month, int year) {
    }
}
