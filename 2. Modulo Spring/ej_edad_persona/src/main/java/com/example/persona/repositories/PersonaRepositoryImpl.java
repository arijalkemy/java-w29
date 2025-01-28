package com.example.persona.repositories;

import com.example.persona.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    List<Persona> personas = new ArrayList<>();

    @Override
    public Boolean save(Persona persona) {
        persona.setId((long) personas.size() + 1);
        return personas.add(persona);
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personas.stream().filter(persona -> persona.getId().equals(id)).findFirst();
    }
}
