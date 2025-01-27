package com.example.starWars.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.*;
import com.example.starWars.entities.Character;

@ToString
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class responseCharacterDto {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public static responseCharacterDto create(Character character){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(character, responseCharacterDto.class);
    }
}
