package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryTest {
    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    public void shouldFindACharacterByName() {
        // Arrange
        CharacterDTO expectedCharacter = new CharacterDTO(
                "Luke Skywalker",
                "blonde",
                "white",
                "blue",
                "1",
                "M",
                "tatooine",
                "human",
                170,
                68
        );
        String query = "Luke";

        // Act
        List<CharacterDTO> actualCharacters = characterRepository.findAllByNameContains(query);

        // Assert
        Assertions.assertEquals(1, actualCharacters.size());
        Assertions.assertTrue(
                actualCharacters.stream()
                        .map(CharacterDTO::getName)
                        .allMatch(name -> name.contains(query))
        );
    }
}
