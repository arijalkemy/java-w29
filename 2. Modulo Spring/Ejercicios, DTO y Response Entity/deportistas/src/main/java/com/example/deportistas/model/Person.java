package com.example.deportistas.model;

public class Person {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Sport sport;

    public Person(String nombre, String apellido, Integer edad, Sport sport) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sport = sport;
    }

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Sport getDeporte() {
        return sport;
    }

    public void setDeporte(Sport sport) {
        this.sport = sport;
    }
}
