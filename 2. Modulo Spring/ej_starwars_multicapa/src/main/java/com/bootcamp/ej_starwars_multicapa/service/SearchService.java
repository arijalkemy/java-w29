package com.bootcamp.ej_starwars_multicapa.service;

import com.bootcamp.ej_starwars_multicapa.dto.CharacterDTO;
import com.bootcamp.ej_starwars_multicapa.repository.IStarWarsCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService {

    private final IStarWarsCharacterRepository characterRepository;

    @Autowired
    public SearchService(IStarWarsCharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> searchCharacters(String query) {
        return characterRepository.searchCharacter(query).stream().map(CharacterDTO::new).toList();
    }
}
