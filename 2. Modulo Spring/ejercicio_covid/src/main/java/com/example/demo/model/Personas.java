package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

public class Personas {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintomas> sintomasasociados;

    //constructors
    public Personas() {
    }

    public Personas(Long id, String nombre, String apellido, Integer edad, List<Sintomas> sintomasasociados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomasasociados = sintomasasociados;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Sintomas> getSintomasasociados() {
        return sintomasasociados;
    }

    public void setSintomasasociados(List<Sintomas> sintomasasociados) {
        this.sintomasasociados = sintomasasociados;
    }

    //to string


    @Override
    public String toString() {
        return "Personas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", sintomasasociados=" + sintomasasociados +
                '}';
    }
}
