package com.mercadolibre.javawave29.star_wars.service;

import com.mercadolibre.javawave29.star_wars.dto.CharacterDTO;
import com.mercadolibre.javawave29.star_wars.model.StarWarsCharacter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IService {
    ResponseEntity<List<CharacterDTO>> getCharacters();
    ResponseEntity<List<CharacterDTO>> getCharactersByName(String name);
    ResponseEntity<CharacterDTO> addCharacter(StarWarsCharacter character);
}
