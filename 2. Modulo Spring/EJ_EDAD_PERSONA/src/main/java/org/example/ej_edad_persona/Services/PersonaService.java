package org.example.ej_edad_persona.Services;

import org.example.ej_edad_persona.Dtos.FechaNacimientoDto;
import org.example.ej_edad_persona.Entities.Persona;

public interface PersonaService {

    Integer calcularEdad(Integer dia, Integer mes, Integer anio);

    Persona addPersona(FechaNacimientoDto fechaNacimientoDto);

    Integer getEdad(Long personaId);
}
