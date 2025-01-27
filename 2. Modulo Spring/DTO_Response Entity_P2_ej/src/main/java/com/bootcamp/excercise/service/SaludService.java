package com.bootcamp.excercise.service;

import com.bootcamp.excercise.entity.PersonaRiesgoDto;
import com.bootcamp.excercise.entity.Sintoma;

import java.util.List;

public interface SaludService {
    List<Sintoma> getAllSyntomps();
    String getSymptomLevel(String nombre);
    List<PersonaRiesgoDto> getRiskPersons();
}
