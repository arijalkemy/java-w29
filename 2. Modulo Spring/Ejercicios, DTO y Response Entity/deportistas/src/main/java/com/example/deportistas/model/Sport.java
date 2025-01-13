package com.example.deportistas.model;

public class Sport {
    private int nivel;
    private String nombre;


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sport(int nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;
    }
}
