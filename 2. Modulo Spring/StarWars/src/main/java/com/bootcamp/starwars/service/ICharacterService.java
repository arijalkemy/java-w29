package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> findByName(String name);
}
