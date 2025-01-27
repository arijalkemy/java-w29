package com.example.starwars.dtos;

import com.example.starwars.entities.Personaje;

public record PersonajeDto (
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear
) {

    public static PersonajeDto toDto(Personaje p) {
        return new PersonajeDto(
                p.getHairColor(),
                p.getSkinColor(),
                p.getEyeColor(),
                p.getBirthYear()
        );
    }

}
