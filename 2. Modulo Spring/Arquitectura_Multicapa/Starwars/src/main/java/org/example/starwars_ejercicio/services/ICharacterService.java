package org.example.starwars_ejercicio.services;

import org.example.starwars_ejercicio.models.Character;

import java.util.List;

public interface ICharacterService {

    List<Character> getCharacters();

    Object getCharactersForWord(String word);
}
