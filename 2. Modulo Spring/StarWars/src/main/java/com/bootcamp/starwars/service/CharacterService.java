package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.repository.CharacterRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    private final CharacterRepository characterRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
        // TODO: Improve Entity to DTO mapping
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<CharacterDTO> findByName(String name) {

        return characterRepository
                .findByName(name)
                .stream()
                .map(c -> objectMapper.convertValue(c, CharacterDTO.class))
                .toList();

    }
}
