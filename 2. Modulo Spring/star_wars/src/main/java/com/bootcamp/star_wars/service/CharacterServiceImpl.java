package com.bootcamp.star_wars.service;

import com.bootcamp.star_wars.dto.response.CharacterDTO;
import com.bootcamp.star_wars.entity.Character;
import com.bootcamp.star_wars.repository.CharacterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getPersonajesByName(String name) {
        List<Character> characters = characterRepository.findByName(name);
        ObjectMapper objectMapper = new ObjectMapper();
        return characters.stream()
                .map(character -> objectMapper.convertValue(character, CharacterDTO.class)).toList();
    }
}
