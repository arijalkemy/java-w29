package com.example.ejercicio_StarWars.Dto;

import com.example.ejercicio_StarWars.Entity.StarWars;

public record StarWarsDto (
        String name,
        String height,
        String mass,
        String gender,
        String homeworld,
        String species
) {
    public static StarWarsDto toDto(StarWars p) {
        return new StarWarsDto(
                p.getName(),
                p.getHeight(),
                p.getMass(),
                p.getGender(),
                p.getHomeworld(),
                p.getSpecies()
        );
    }
}