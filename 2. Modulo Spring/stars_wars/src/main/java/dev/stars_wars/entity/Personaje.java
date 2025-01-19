package dev.stars_wars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
    @JsonProperty("hair_color")
    private String hair_color;

    @JsonProperty("skin_color")
    private String skin_color;

    @JsonProperty("eye_color")
    private String eye_color;

    @JsonProperty("birth_year")
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public Personaje() {
    }


    public Personaje(String name, Integer height, Integer mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hairColor;
        this.skin_color = skinColor;
        this.eye_color = eyeColor;
        this.birth_year = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getHair_Color() {
        return hair_color;
    }

    public void setHair_Color(String hair_Color) {
        this.hair_color = hair_Color;
    }

    public String getSkinColor() {
        return skin_color;
    }

    public void setSkinColor(String skinColor) {
        this.skin_color = skinColor;
    }

    public String getEyeColor() {
        return eye_color;
    }

    public void setEyeColor(String eyeColor) {
        this.eye_color = eyeColor;
    }

    public String getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(String birthYear) {
        this.birth_year = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
