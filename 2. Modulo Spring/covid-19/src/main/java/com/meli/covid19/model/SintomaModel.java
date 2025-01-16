package com.meli.covid19.model;

public class SintomaModel {
    public Integer codigo;
    public String nombre;
    public Integer nivel_de_gravedad;

    public SintomaModel(Integer codigo, String nombre, Integer nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
