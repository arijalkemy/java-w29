package com.bootcamp.covid.entities;

import com.bootcamp.covid.enums.NivelDeGravedad;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {

    private long codigo;

    private String nombre;

    private NivelDeGravedad nivelDeGravedad;

}
