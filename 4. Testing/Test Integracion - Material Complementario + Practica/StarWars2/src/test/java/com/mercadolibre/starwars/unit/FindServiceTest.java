package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Should find a character by name")
    public void findCharacterTest() {
        // Arrange
        CharacterDTO characterDTO = createCharacter();
        String query = "Luke";
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(characterDTO));

        // Act
        List<CharacterDTO> matches = findService.find(query);

        // Assert
        assertFalse(matches.isEmpty());
        assertEquals(characterDTO, matches.get(0));

    }

    @Test
    @DisplayName("Should not find a non existing character")
    public void findNonExistingCharacterTest() {
        // Arrange
        String query = "Luke";
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(List.of());

        // Act
        List<CharacterDTO> matches = findService.find(query);

        // Assert
        assertTrue(matches.isEmpty());
    }

    private static CharacterDTO createCharacter() {
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
