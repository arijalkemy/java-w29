package com.mercadolibre.javawave29.star_wars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
