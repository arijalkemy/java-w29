package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Find list character by name")
    void findListOkTest() {
        String query = "Luke";
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        CharacterDTO c3 = new CharacterDTO();
        c1.setName("Darth 1");
        c2.setName("Darth 2");
        c3.setName("Darth 3");
        List<CharacterDTO> characters = List.of(c1, c2, c3);
        when(findService.find(anyString())).thenReturn(characters);

        List<CharacterDTO> characterDTOS = findController.find(query);

        assertFalse(characterDTOS.isEmpty());
        assertEquals(characters, characterDTOS);
    }

    @Test
    @DisplayName("Find list character by name none found")
    void findListNotFound() {
        String query = "Luke";
        when(findService.find(anyString())).thenReturn(new ArrayList<>());

        List<CharacterDTO> characterDTOS = findController.find(query);

        assertTrue(characterDTOS.isEmpty());
    }
}