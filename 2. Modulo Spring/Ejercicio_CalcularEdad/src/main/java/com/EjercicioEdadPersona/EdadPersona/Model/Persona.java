package com.EjercicioEdadPersona.EdadPersona.Model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private Integer id;
    private String nombre;
    private Integer dia;
    private Integer mes;
    private Integer anio;
    private Integer edad;

    public Persona(Integer id, String nombre, Integer dia, Integer mes, Integer anio) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = calcularEdad();
    }

    public Integer calcularEdad() {
        LocalDate fNacimiento = LocalDate.of(this.anio, this.mes, this.dia);
        LocalDate fActual = LocalDate.now();
        Period edad = Period.between(fNacimiento, fActual);
        return edad.getYears();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                ", edad= " + getEdad() +
                '}';
    }
}