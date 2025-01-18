package com.bootcamp.starwars.dto;

public record CharacterDTO(
         String name,
         String height,
         String mass,
         String gender,
         String homeworld,
         String species
) {
}
