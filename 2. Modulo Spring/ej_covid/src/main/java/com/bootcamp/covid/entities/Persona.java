package com.bootcamp.covid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {

    private long id;

    private String nombre;

    private String apellido;

    private int edad;

    private List<Sintoma> sintomas;

}
