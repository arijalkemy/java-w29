package com.org.meli.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
    String name;
    Integer height;
    Integer mass;
    String gender;
    String homeworld;
    String species;
}
