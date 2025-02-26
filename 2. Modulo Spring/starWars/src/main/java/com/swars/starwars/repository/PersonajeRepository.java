package com.swars.starwars.repository;

import com.swars.starwars.dto.CharacterDTO;

import java.util.List;

public interface PersonajeRepository {
    List<CharacterDTO> findAllByNameContains(String query);
}
