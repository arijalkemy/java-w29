package com.bootcamp.covid.repositories;

import com.bootcamp.covid.entities.Persona;

import java.util.List;

public interface PersonasRepository {
    List<Persona> findAll();
}
