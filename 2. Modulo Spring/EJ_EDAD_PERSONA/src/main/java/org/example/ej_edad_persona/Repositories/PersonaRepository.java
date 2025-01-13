package org.example.ej_edad_persona.Repositories;

import org.example.ej_edad_persona.Entities.Persona;

import java.util.Optional;

public interface PersonaRepository {

    Boolean save(Persona persona);

    Optional<Persona> findById(Long id);
}
