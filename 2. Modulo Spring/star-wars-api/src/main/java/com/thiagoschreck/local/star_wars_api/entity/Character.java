package com.thiagoschreck.local.star_wars_api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public record Character(
        String name,
        String height,
        String mass,
        @JsonProperty("hair_color")
        String hairColor,
        @JsonProperty("skin_color")
        String skinColor,
        @JsonProperty("eye_color")
        String eyeColor,
        @JsonProperty("birth_year")
        String birthYear,
        String gender,
        String homeworld,
        String species) {
}
