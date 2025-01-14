package com.bootcamp.ej_covid_19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
}
