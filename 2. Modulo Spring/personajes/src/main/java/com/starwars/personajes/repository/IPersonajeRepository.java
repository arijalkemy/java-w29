package com.starwars.personajes.repository;

import com.starwars.personajes.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> getPersonajesByName(String name);
}
