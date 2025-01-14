package com.meli.ej_starwars.service;

import com.meli.ej_starwars.model.Personaje;

import java.util.List;

public interface PersonajeService {
    List<Personaje> findAllPersonajesByName(String name);
}
