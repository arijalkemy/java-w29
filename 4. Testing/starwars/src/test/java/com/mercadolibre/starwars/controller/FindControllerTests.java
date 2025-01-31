package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @BeforeEach
    void setup() {
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        CharacterDTO c3 = new CharacterDTO();
        c1.setName("Luke 1");
        c2.setName("Luke 2");
        c3.setName("Luke 3");
        List<CharacterDTO> characters = List.of(c1, c2, c3);

        Mockito.when(findService.find(anyString())).thenReturn(characters);
    }

    @Test
    void testFindAllByNameContains_FullMatch() {
        // 1. Arrange
        // - Done in setup

        // 2. Act
        List<CharacterDTO> results = findController.find("Luke");

        // 3. Assert
        assertNotNull(results);
        assertFalse(results.isEmpty());
    }

}
