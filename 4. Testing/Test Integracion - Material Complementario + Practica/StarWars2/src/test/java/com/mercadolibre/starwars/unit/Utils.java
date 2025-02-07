package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;

public abstract class Utils {
    public static CharacterDTO createCharacterDTO() {
        return CharacterDTO
                .builder()
                .name("Luke Skywalker")
                .height(172)
                .mass(77)
                .hair_color("blond")
                .skin_color("fair")
                .eye_color("blue")
                .birth_year("19BBY")
                .gender("male")
                .homeworld("Tatooine")
                .species("Human")
                .build();
    }
}
