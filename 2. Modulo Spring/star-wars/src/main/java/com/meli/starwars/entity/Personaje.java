package com.meli.starwars.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.meli.starwars.util.CustomIntegerDeserializer;

public class Personaje {
    public String name;
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    public Integer height;
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    public Integer mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public String species;

    public Personaje(String birth_year, String eye_color, String gender, String hairColor, Integer height, String homeworld, Integer mass, String name, String skin_color, String species) {
        this.birth_year = birth_year;
        this.eye_color = eye_color;
        this.gender = gender;
        this.hair_color = hairColor;
        this.height = height;
        this.homeworld = homeworld;
        this.mass = mass;
        this.name = name;
        this.skin_color = skin_color;
        this.species = species;
    }

    public Personaje() {
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
