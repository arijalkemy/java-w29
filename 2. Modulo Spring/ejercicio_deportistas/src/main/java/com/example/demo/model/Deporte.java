package com.example.demo.model;

//Deporte, cuyos atributos serán:
//Nombre
//Nivel
public class Deporte {
    private String nombre;
    private  Integer nivel;


    //setters y getters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    //constructor


    public Deporte(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    //to string


    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
