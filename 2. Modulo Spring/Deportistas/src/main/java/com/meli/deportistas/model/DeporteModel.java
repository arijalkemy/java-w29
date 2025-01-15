package com.meli.deportistas.model;

public class DeporteModel {
    public String nombre;
    public Integer nivel;

    public DeporteModel(Integer nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
