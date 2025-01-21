package com.example.demo.model;

public class Sintomas {
    private Integer codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

    //constructors

    public Sintomas() {
    }

    public Sintomas(Integer codigo, String nombre, Integer nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    //getters y setters

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(Integer nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    //to string


    @Override
    public String toString() {
        return "Sintomas{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                '}';
    }
}
