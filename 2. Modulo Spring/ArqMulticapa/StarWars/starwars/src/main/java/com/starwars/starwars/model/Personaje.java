package com.starwars.starwars.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Personaje {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public String getName() { return name; }
}
