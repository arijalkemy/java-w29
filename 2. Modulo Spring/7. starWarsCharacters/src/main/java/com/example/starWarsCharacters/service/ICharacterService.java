package com.example.starWarsCharacters.service;

import com.example.starWarsCharacters.dto.CharacterDto;
import com.example.starWarsCharacters.entity.Character;

import java.util.List;

public interface ICharacterService {

    void addCharacter(Character character);
    List<CharacterDto> getCharacterByName(String name);
}
