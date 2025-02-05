package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Find a list of characters by name")
    void findOkTest() {
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        CharacterDTO c3 = new CharacterDTO();
        c1.setName("Darth 1");
        c2.setName("Darth 2");
        c3.setName("Darth 3");
        List<CharacterDTO> characters = List.of(c1, c2, c3);
        List<CharacterDTO> response;

        String query = "Darth";
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);

        response = findService.find(query);

        assertFalse(response.isEmpty());
        assertEquals(characters.size(), response.size());
        assertEquals(characters, response);
    }

    @Test
    @DisplayName("Find a list of characters by name and not found")
    void findNotFoundTest() {
        List<CharacterDTO> response;

        String query = "Darth";
        when(characterRepository.findAllByNameContains(query)).thenReturn(new ArrayList<>());

        response = findService.find(query);

        assertTrue(response.isEmpty());
    }
}