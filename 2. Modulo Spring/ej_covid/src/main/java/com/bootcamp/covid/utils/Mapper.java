package com.bootcamp.covid.utils;

import com.bootcamp.covid.dtos.PersonaRiesgoDto;
import com.bootcamp.covid.dtos.SintomaDto;
import com.bootcamp.covid.entities.Persona;
import com.bootcamp.covid.entities.Sintoma;

public class Mapper {
    public static PersonaRiesgoDto toDto(Persona persona) {
        return new PersonaRiesgoDto(
                String.format("%s %s", persona.getNombre(), persona.getApellido()),
                persona.getEdad()
        );
    }

    public static SintomaDto toDto(Sintoma sintoma) {
        return new SintomaDto(sintoma.getNombre(), sintoma.getNivelDeGravedad().getString());
    }
}
