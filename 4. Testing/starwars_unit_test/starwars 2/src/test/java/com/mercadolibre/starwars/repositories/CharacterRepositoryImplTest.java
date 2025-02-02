package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        List<CharacterDTO> personajes = Arrays.asList(
                new CharacterDTO("Poe Dameron", "brown", "light", "brown", "NA", "male", "NA", "Human", null, null),
                new CharacterDTO("BB8", "none", "none", "black", "NA", "none", "NA", "Droid", null, null),
                new CharacterDTO("Captain Phasma", "NA", "NA", "NA", "NA", "female", "NA", "NA", null, null),
                new CharacterDTO("Padmé Amidala", "brown", "light", "brown", "46BBY", "female", "Naboo", "Human", 165, 45)
        );

        // Inyectamos la base de datos en memoria
        repository = new CharacterRepositoryImpl(personajes);
    }

    @Test
    void findByNameTest(){
        //arrange
        String params = "admé";
        //act
        List<CharacterDTO> resultado = repository.findAllByNameContains(params);
        //assert
        assertEquals(1, resultado.size());
        assertEquals("Padmé Amidala", resultado.get(0).getName());
        assertEquals("brown", resultado.get(0).getHair_color());
        assertEquals("light", resultado.get(0).getSkin_color());
        assertEquals("brown", resultado.get(0).getEye_color());
    }

}