package com.Covid_19.covid.DTO;

public class SintomaDTO {
    private String nombre;
    private String nivelGravedad;

    public SintomaDTO( String nombre, String nivelGravedad) {
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
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
