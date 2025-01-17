package com.starwars.personajes.service;

import com.starwars.personajes.dto.response.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    public List<PersonajeDTO> getPersonajesByName(String nombre);
}
