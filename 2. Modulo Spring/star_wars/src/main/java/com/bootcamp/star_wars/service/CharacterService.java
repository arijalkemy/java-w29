package com.bootcamp.star_wars.service;

import com.bootcamp.star_wars.dto.response.CharacterDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> getPersonajesByName(String name);
}
