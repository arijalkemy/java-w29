package com.bootcamp.starwars.dto;

import com.bootcamp.starwars.entity.Character;
import lombok.Data;

@Data
public class CharacterDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
