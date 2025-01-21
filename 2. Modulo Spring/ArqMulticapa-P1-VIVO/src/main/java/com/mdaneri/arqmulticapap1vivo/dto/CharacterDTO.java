package com.mdaneri.arqmulticapap1vivo.dto;

import com.mdaneri.arqmulticapap1vivo.entity.Character;

public class CharacterDTO {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public static CharacterDTO from(Character c) {
        return new CharacterDTO(
                c.getName(),
                c.getHeight(),
                c.getMass(),
                c.getGender(),
                c.getHomeworld(),
                c.getSpecies()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
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

