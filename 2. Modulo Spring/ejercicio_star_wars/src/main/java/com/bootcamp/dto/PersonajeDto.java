package com.bootcamp.dto;

public class PersonajeDto {
    private String nombre;

    public PersonajeDto(String nombre) {
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
