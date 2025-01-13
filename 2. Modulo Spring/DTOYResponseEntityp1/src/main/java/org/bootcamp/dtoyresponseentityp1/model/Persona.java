package org.bootcamp.dtoyresponseentityp1.model;

public record Persona(int id, FechaDeNacimiento fechaDeNacimiento) {
    public record FechaDeNacimiento(int day,
                                    int month,
                                    int year) {
    }
}