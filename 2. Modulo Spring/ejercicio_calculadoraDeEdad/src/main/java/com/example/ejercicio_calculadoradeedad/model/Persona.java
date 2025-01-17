package com.example.ejercicio_calculadoradeedad.model;

public record Persona(int id, FechaDeNacimiento fechaDeNacimiento) {
    public record FechaDeNacimiento(int day, int month, int year) {
    }
}