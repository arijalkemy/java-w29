package com.Covid_19.covid.Model;

public class Sintoma {
    private Integer codigo;
    private String nombre;
    private String nivelGravedad;

    public Sintoma(Integer codigo, String nombre, String nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

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

    public String getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(String nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }
}
