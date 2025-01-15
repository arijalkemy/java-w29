package com.example.starWarsCharacters.repository;

import com.example.starWarsCharacters.dto.CharacterDto;
import com.example.starWarsCharacters.entity.Character;

import java.util.List;

public interface ICharacterRepository {

    void addCharacter(Character character);
    List<Character> getCharacterByName(String name);
}
