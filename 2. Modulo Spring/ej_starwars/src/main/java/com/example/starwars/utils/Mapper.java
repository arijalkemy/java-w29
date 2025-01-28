package com.example.starwars.utils;

import com.example.starwars.dtos.PersonajeDto;
import com.example.starwars.entities.Personaje;

public class Mapper {
    public static PersonajeDto toDto(Personaje p) {
        return new PersonajeDto(
                p.getHairColor(),
                p.getSkinColor(),
                p.getEyeColor(),
                p.getBirthYear()
        );
    }
}
