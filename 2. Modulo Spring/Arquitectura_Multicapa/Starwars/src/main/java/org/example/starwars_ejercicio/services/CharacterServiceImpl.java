package org.example.starwars_ejercicio.services;

import org.example.starwars_ejercicio.models.Character;
import org.example.starwars_ejercicio.repositories.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    @Autowired
    private ICharacterRepository characterRepository;

    @Override
    public List<Character> getCharacters() {
        return characterRepository.getAll();
    }

    @Override
    public Object getCharactersForWord(String word) {
        return characterRepository.getAll().stream().filter(c-> c.getName().toLowerCase().contains(word.toLowerCase()));
    }
}
