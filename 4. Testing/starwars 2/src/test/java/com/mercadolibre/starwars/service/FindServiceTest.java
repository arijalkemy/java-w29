package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        CharacterDTO c3 = new CharacterDTO();
        c1.setName("Character 1");
        c2.setName("Character 2");
        c3.setName("Character 3");
        List<CharacterDTO> characters = List.of(c1, c2, c3);
        Mockito.when(characterRepository.findAllByNameContains(anyString())).thenReturn(characters);

        List<CharacterDTO> findList = findService.find("Character 1");

        assertEquals(characters, findList);
    }
}