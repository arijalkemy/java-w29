package com.bootcamp.ej_starwars_multicapa.service;

import com.bootcamp.ej_starwars_multicapa.dto.CharacterDTO;

import java.util.List;

public interface ISearchService {
    List<CharacterDTO> searchCharacters(String searchString);
}
