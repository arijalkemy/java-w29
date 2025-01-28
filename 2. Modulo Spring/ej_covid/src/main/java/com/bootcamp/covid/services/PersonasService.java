package com.bootcamp.covid.services;

import com.bootcamp.covid.dtos.PersonaRiesgoDto;

import java.util.List;

public interface PersonasService {
    List<PersonaRiesgoDto> getPersonasRiesgo();
}
