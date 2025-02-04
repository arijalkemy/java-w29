package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void shouldFindOnlyOneCharacter() {
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

        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(expectedCharacter));

        // Act
        List<CharacterDTO> actualCharacters = findService.find(query);

        // Assert
        Assertions.assertEquals(1, actualCharacters.size());
        Assertions.assertTrue(
                actualCharacters.stream()
                        .map(CharacterDTO::getName)
                        .allMatch(name -> name.contains(query))
        );
    }

    @Test
    public void shoulFindMultipleCharacters() {
        CharacterDTO darthVader = new CharacterDTO(
                "Darth Vader",
                "blonde",
                "white",
                "blue",
                "0",
                "M",
                "no idea",
                "human",
                194,
                93
        );

        CharacterDTO darthMaul = new CharacterDTO(
                "Darth Maul",
                "red",
                "black & red",
                "yellow",
                "1",
                "M",
                "brazil",
                "human",
                172,
                75
        );
        String query = "Darth";

        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(darthVader, darthMaul));

        // Act
        List<CharacterDTO> actualCharacters = findService.find(query);

        // Assert
        Assertions.assertEquals(2, actualCharacters.size());
        Assertions.assertTrue(
                actualCharacters.stream()
                        .map(CharacterDTO::getName)
                        .allMatch(name -> name.contains(query))
        );
    }
}
