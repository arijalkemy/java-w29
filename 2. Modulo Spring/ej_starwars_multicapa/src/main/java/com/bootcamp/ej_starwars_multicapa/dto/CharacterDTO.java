package com.bootcamp.ej_starwars_multicapa.dto;

import com.bootcamp.ej_starwars_multicapa.model.StarWarsCharacter;
import lombok.Data;

@Data
public class CharacterDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO(StarWarsCharacter character) {
        this.name = character.getName();
        this.height = character.getHeight();
        this.mass = character.getMass();
        this.gender = character.getGender();
        this.homeworld = character.getHomeworld();
        this.species = character.getSpecies();
    }
}
