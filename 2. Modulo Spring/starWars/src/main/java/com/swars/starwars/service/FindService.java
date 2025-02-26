package com.swars.starwars.service;

import com.swars.starwars.dto.CharacterDTO;
import com.swars.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
    private final PersonajeRepository characterRepository;

    public FindService(PersonajeRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> find(String query) {
        return characterRepository.findAllByNameContains(query);
    }
}
