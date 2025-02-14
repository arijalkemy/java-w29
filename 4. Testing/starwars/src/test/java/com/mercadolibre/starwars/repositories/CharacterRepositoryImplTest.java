package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    @Test
    void findAllByNameContains() {
        // Arrange
        CharacterRepository characterRepository = new CharacterRepositoryImpl();
        String query = "luke";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert
        assertNotNull(result);
    }

    @Test
    void findAllByNameContainsEmpty() {
        // Arrange
        CharacterRepository characterRepository = new CharacterRepositoryImpl();
        String query = "nonexistentname";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void findAllByEmptyQuery() {
        // Arrange
        CharacterRepository characterRepository = new CharacterRepositoryImpl();
        String query = "";

        // Act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // Assert
        assertTrue(result.size() >= 1);
    }
}