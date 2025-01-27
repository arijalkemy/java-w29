package com.bootcamp.excercise.entity;

public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public Sintoma(String codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}