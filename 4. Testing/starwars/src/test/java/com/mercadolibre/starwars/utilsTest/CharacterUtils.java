package com.mercadolibre.starwars.utilsTest;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class CharacterUtils {

    private CharacterUtils() {
    }

    public static CharacterDTO createCharacterDTO(
            String name, String hairColor, String skinColor, String eyeColor,
            String birthYear, String gender, String homeworld, String species,
            Integer height, Integer mass) {

        CharacterDTO character = new CharacterDTO();
        character.setName(name);
        character.setHair_color(hairColor);
        character.setSkin_color(skinColor);
        character.setEye_color(eyeColor);
        character.setBirth_year(birthYear);
        character.setGender(gender);
        character.setHomeworld(homeworld);
        character.setSpecies(species);
        character.setHeight(height);
        character.setMass(mass);

        return character;
    }
}
