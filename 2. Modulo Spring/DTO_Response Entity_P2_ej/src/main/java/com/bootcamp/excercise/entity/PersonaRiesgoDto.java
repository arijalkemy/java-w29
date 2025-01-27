package com.bootcamp.excercise.entity;

public class PersonaRiesgoDto {
    private String nombre;
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public PersonaRiesgoDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
