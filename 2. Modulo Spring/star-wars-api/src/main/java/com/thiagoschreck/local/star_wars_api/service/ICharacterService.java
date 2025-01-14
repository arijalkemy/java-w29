package com.thiagoschreck.local.star_wars_api.service;

import com.thiagoschreck.local.star_wars_api.dto.response.CharacterResponseDTO;

import java.util.List;

public interface ICharacterService {

    List<CharacterResponseDTO> getAllCharacters();

    List<CharacterResponseDTO> getCharactersByName(String name);
}
