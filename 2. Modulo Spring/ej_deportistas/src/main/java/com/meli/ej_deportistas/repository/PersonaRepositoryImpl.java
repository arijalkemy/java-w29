package com.meli.ej_deportistas.repository;

import com.meli.ej_deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {

    private List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> findAll() {
        return this.personas;
    }

    @Override
    public void save(Persona persona) {
        this.personas.add(persona);
    }
}
