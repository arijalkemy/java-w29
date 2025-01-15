package com.meli.deportistas.model;

public class PersonaModel {
    public String nombre;
    public String apellido;
    public Integer edad;

    public PersonaModel(String apellido, Integer edad, String nombre) {
        this.apellido = apellido;
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
