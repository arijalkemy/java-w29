package com.bootcamp.ej_covid_19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private Integer codigo;
    private String nombre;
    private Integer nivelDeGravedad;
}
