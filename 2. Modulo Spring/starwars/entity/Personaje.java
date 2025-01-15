package com.api.starwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
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

    public Personaje() {
    }

    @JsonSetter("height")
    public void setHeight(String height) {
        try {
            this.height = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            this.height = null;
        }
    }

    @JsonSetter("mass")
    public void setMass(String mass) {
        try {
            this.mass = Integer.parseInt(mass);
        } catch (NumberFormatException e) {
            this.mass = null;
        }
    }
}

