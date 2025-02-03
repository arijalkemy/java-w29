package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void givenValidQuery_whenFind_thenReturnCharacterList() {
        List<CharacterDTO> mockCharacters = List.of(
                new CharacterDTO(),
                new CharacterDTO(),
                new CharacterDTO(),
                new CharacterDTO()
        );
        String query = "Darth Maul";
        when(characterRepository.findAllByNameContains(query)).thenReturn(mockCharacters);

        List<CharacterDTO> resultCharacters = findService.find(query);

        assertEquals(4, resultCharacters.size());
        assertEquals(mockCharacters, resultCharacters);
        verify(characterRepository, times(1)).findAllByNameContains(query);
    }

    @Test
    void givenEmptyQuery_whenFind_thenReturnEmptyCharacterList() {
        List<CharacterDTO> mockCharacters = List.of();
        String query = "";
        when(characterRepository.findAllByNameContains(query)).thenReturn(mockCharacters);

        List<CharacterDTO> resultCharacters = findService.find(query);

        assertNotNull(resultCharacters);
        assertEquals(0, resultCharacters.size());
        verify(characterRepository, times(1)).findAllByNameContains(query);
    }
}
