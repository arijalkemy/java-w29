package com.meli.ej_starwars.repository;

import com.meli.ej_starwars.model.Personaje;

import java.util.List;


public interface PersonajeRepository {
    List<Personaje> findAll();
    List<Personaje> findAllByName(String name);
}
