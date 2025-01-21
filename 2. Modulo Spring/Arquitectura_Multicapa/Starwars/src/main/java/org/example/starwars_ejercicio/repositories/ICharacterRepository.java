package org.example.starwars_ejercicio.repositories;

import org.example.starwars_ejercicio.dto.CharacterDTO;
import org.example.starwars_ejercicio.models.Character;

import java.util.List;


public interface ICharacterRepository {

    List<Character> getAll();
    Character findById(Integer id);
    CharacterDTO addCharacter(Character character);
}
