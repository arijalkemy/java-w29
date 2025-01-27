package com.example.persona.services;

import com.example.persona.dtos.FechaNacimientoDto;
import com.example.persona.entities.Persona;

public interface PersonaService {

    Integer calcularEdad(Integer dia, Integer mes, Integer anio);

    Persona addPersona(FechaNacimientoDto fechaNacimiento);

    Integer getEdad(Long personaId);

}
