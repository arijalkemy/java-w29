package com.bootcamp.covid.dtos;

import com.bootcamp.covid.entities.Persona;

public record PersonaRiesgoDto (String nombreCompleto, Integer edad) {

    public static PersonaRiesgoDto toDto(Persona persona) {
        return new PersonaRiesgoDto(
                String.format("%s %s", persona.getNombre(), persona.getApellido()),
                persona.getEdad()
        );
    }

}
