package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service ;

    @Test
    void testFindAllByNameContains() {
        //arrange
        String query = "admé";
        List<CharacterDTO> personajesEsperados = Arrays.asList(
                new CharacterDTO("Padmé Amidala", "brown", "light", "brown", "46BBY", "female", "Naboo", "Human", 165, 45)
        );

        when(characterRepository.findAllByNameContains(query)).thenReturn(personajesEsperados);
        //act

        List<CharacterDTO> result = service.find(query);
        assertEquals(personajesEsperados, result, "Los personajes devueltos no coinciden con los esperados.");
    }



}