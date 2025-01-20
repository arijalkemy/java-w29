package org.example.starwars_ejercicio.services;

import org.example.starwars_ejercicio.dto.CharacterDTO;
import org.example.starwars_ejercicio.models.Character;

import java.util.List;

public interface ICharacterService {

    List<CharacterDTO> getCharacters();

    List<CharacterDTO>getCharactersForWord(String word);
}
