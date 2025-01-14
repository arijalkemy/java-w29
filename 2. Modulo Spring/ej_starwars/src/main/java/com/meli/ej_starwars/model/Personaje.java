package com.meli.ej_starwars.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.meli.ej_starwars.util.NumberDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name;

    @JsonDeserialize(using = NumberDeserializer.class)
    private Integer height;

    @JsonDeserialize(using = NumberDeserializer.class)
    private Integer mass;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("birth_year")
    @JsonDeserialize(using = NumberDeserializer.class)
    private Integer birthYear;
    private String gender;
    private String homeworld;
    private String species;
}
