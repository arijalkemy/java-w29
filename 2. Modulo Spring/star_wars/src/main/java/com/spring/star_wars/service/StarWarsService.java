package com.spring.star_wars.service;

import com.spring.star_wars.dto.SWCharacterDTO;

import java.util.List;

public interface StarWarsService {
    public List<SWCharacterDTO> findCharactersNamed(String partialName);
}
