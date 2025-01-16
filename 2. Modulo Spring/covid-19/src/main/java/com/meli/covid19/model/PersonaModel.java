package com.meli.covid19.model;

import java.util.ArrayList;
import java.util.List;

public class PersonaModel {
    public Integer id;
    public String nombre;
    public String apellido;
    public Integer edad;
    public List<Integer> sintomas;

    public PersonaModel(String apellido, Integer edad, Integer id, String nombre, List<Integer> sintomas) {
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
        this.nombre = nombre;
        this.sintomas = (sintomas != null) ? new ArrayList<>(sintomas) : new ArrayList<>();
    }
}