package com.bootcamp.excercise.repository;

import com.bootcamp.excercise.entity.Persona;

import java.util.List;

public interface PersonaRepository {
    List<Persona> findAllPersons();
    List<Persona> findPersonsWithSymptoms();
}
