package com.starwars.personajes.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
