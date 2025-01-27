package com.example.persona.repositories;

import com.example.persona.entities.Persona;

import java.util.Optional;

public interface PersonaRepository {

    Boolean save(Persona persona);

    Optional<Persona> getById(Long id);

}
