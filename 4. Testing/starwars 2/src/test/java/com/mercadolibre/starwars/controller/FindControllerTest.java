package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void find() {
        String query = "Luke";
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        CharacterDTO c3 = new CharacterDTO();
        c1.setName("Character 1");
        c2.setName("Character 2");
        c3.setName("Character 3");
        List<CharacterDTO> characters = List.of(c1, c2, c3);
        when(findService.find(anyString())).thenReturn(characters);

        List<CharacterDTO> characterDTOS = findController.find(query);

        assertEquals(characters, characterDTOS);
    }
}