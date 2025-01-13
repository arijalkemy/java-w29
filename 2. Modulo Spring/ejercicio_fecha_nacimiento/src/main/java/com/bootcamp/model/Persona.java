package com.bootcamp.model;

public class Persona {

    private Long id;
    private Integer dia;
    private Integer mes;
    private Integer anio;

    public Persona() {
    }

    public Persona(Long id, Integer dia, Integer mes, Integer anio) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

}
