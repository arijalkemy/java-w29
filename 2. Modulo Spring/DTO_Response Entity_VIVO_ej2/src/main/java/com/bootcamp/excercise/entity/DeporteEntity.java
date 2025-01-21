package com.bootcamp.excercise.entity;

public class DeporteEntity {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public DeporteEntity(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    private String nivel;

}
