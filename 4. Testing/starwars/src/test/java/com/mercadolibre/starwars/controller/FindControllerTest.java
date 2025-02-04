package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void shouldFindACharacter() {
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

        Mockito.when(findService.find(query)).thenReturn(List.of(expectedCharacter));

        // Act
        List<CharacterDTO> actualCharacters = findController.find(query);

        // Assert
        Assertions.assertEquals(1, actualCharacters.size());
        Assertions.assertTrue(
                actualCharacters.stream()
                        .map(CharacterDTO::getName)
                        .allMatch(name -> name.contains(query))
        );
    }

}
