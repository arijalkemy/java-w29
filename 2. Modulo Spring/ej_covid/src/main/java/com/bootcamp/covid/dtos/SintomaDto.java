package com.bootcamp.covid.dtos;

import com.bootcamp.covid.entities.Sintoma;

public record SintomaDto(String nombre, String nivelDeGravedad) {

    public static SintomaDto toDto(Sintoma sintoma) {
        return new SintomaDto(sintoma.getNombre(), sintoma.getNivelDeGravedad().getString());
    }

}
