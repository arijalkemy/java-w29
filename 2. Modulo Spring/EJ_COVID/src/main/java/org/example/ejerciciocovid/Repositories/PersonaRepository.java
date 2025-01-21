package org.example.ejerciciocovid.Repositories;

import org.example.ejerciciocovid.Entities.Persona;

import java.util.List;

public interface PersonaRepository {

    List<Persona> getAll();
}
