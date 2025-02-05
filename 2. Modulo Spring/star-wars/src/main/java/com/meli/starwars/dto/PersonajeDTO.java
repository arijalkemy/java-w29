package com.meli.starwars.dto;

public class PersonajeDTO {
    public String name;
    public Integer height;
    public Integer mass;
    public String gender;
    public String homeworld;
    public String species;

    public PersonajeDTO(String gender, String homeworld, Integer height, Integer mass, String name, String species) {
        this.gender = gender;
        this.homeworld = homeworld;
        this.height = height;
        this.mass = mass;
        this.name = name;
        this.species = species;
    }
}
