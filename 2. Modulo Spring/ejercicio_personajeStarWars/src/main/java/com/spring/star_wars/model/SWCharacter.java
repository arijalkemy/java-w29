package com.spring.star_wars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SWCharacter(
    String name,
    Integer height,
    Integer mass,
    @JsonProperty("hair_color")
    String hairColor,
    @JsonProperty("skin_color")
    String skinColor,
    @JsonProperty("eye_color")
    String eyeColor,
    @JsonProperty("birth_year")
    String birthYear,
    String gender,
    @JsonProperty("homeworld")
    String homeWorld,
    String species
) {}
