package com.example.demo.deportistas;


import java.io.Serializable;

public class Deporte implements Serializable{
    private int nivel;
    private String nombre;

    public Deporte(int nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;
    }
    public Deporte() {
    }
    public int getNivel() {
        return nivel;
    }
    public String getNombre() {
        return nombre;
    }
}