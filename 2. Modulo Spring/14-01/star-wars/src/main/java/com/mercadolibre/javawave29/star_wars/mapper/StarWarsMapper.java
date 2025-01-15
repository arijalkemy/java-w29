package com.mercadolibre.javawave29.star_wars.mapper;

import com.mercadolibre.javawave29.star_wars.dto.CharacterDTO;
import com.mercadolibre.javawave29.star_wars.model.StarWarsCharacter;

public class StarWarsMapper {
    public CharacterDTO characterToDTO (StarWarsCharacter character) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(character.getName());
        characterDTO.setGender(character.getGender());
        characterDTO.setHeight(character.getHeight());
        characterDTO.setHomeworld(character.getHomeworld());
        characterDTO.setMass(character.getMass());
        characterDTO.setSpecies(character.getSpecies());
        return characterDTO;
    }
}
