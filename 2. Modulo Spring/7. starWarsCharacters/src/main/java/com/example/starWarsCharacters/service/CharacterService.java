package com.example.starWarsCharacters.service;

import com.example.starWarsCharacters.dto.CharacterDto;
import com.example.starWarsCharacters.entity.Character;
import com.example.starWarsCharacters.repository.CharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacterService implements ICharacterService {
    private final CharacterRepository characterRepository;

    @Override
    public void addCharacter(Character character) {
        characterRepository.addCharacter(character);
    }

    @Override
    public List<CharacterDto> getCharacterByName(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(characterRepository.getCharacterByName(name), new TypeReference<List<CharacterDto>>() {});
    }
}
