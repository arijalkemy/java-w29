package com.meli.starwars.service;

import com.meli.starwars.dto.response.PersonajeResponseDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeResponseDTO> searchByName(String name);
}
