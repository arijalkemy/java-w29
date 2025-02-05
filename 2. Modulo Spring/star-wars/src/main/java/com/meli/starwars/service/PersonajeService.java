package com.meli.starwars.service;

import com.meli.starwars.dto.PersonajeDTO;
import com.meli.starwars.entity.Personaje;

import java.util.List;

public interface PersonajeService {
    List<PersonajeDTO> findByName(String name);
    List<PersonajeDTO> findAll();
}
