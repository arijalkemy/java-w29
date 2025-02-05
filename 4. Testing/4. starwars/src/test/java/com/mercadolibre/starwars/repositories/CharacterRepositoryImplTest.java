package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    public static CharacterRepository characterRepository;

    @BeforeAll
    static void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("CU1 - Find all characters by name happy path")
    void findAllByNameContainsOkTest() {
        String query = "Darth";
        List<CharacterDTO> characterDTOS;

        characterDTOS = characterRepository.findAllByNameContains(query);

        assertFalse(characterDTOS.isEmpty());
        assertTrue(characterDTOS.stream().allMatch(c -> c.getName().toUpperCase().contains(query.toUpperCase())));
    }

    @Test
    @DisplayName("Find none of characters by name")
    void findAllByNameContainsNotFoundTest() {
        String query = "Nombre";
        List<CharacterDTO> characterDTOS;

        characterDTOS = characterRepository.findAllByNameContains(query);

        assertTrue(characterDTOS.isEmpty());
    }
}