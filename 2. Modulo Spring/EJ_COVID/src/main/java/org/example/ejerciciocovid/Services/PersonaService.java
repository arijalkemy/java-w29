package org.example.ejerciciocovid.Services;

import org.example.ejerciciocovid.Dtos.PersonaRiesgoDto;

import java.util.List;

public interface PersonaService {

    List<PersonaRiesgoDto> getPersonasRiesgo();
}
