package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void findCharacterTest() {
        // Arrange
        CharacterDTO characterDTO = Utils.createCharacterDTO();
        String query = characterDTO.getName();
        when(findService.find(query)).thenReturn(List.of(characterDTO));

        // Act
        List<CharacterDTO> results = findController.find(query);

        // Assert
        assertTrue(results.contains(characterDTO));
    }

    @Test
    public void findCharacterNotFoundTest() {
        // Arrange
        String query = "Neo";
        when(findService.find(query)).thenReturn(List.of());

        // Act
        List<CharacterDTO> results = findController.find(query);

        // Assert
        assertTrue(results.isEmpty());

    }

}
