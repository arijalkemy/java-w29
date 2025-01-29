package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindService {

    private final CharacterRepository characterRepository;

    public List<CharacterDTO> find(String query) {
        return characterRepository.findAllByNameContains(query);
    }
}
