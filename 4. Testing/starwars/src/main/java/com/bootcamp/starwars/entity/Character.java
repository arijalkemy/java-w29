package com.bootcamp.starwars.entity;

import com.bootcamp.starwars.utils.SafeIntegerDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class Character {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    @JsonDeserialize(using = SafeIntegerDeserializer.class)
    private Integer height;
    @JsonProperty("mass")
    @JsonDeserialize(using = SafeIntegerDeserializer.class)
    private Integer mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;
}
