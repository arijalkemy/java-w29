package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void test_find_ok() {
        // 1. Arrange
        CharacterDTO c1 = new CharacterDTO();
        CharacterDTO c2 = new CharacterDTO();
        CharacterDTO c3 = new CharacterDTO();
        c1.setName("Character 1");
        c2.setName("Character 2");
        c3.setName("Character 3");
        List<CharacterDTO> characters = List.of(c1, c2, c3);
        Mockito.when(characterRepository.findAllByNameContains(anyString())).thenReturn(characters);

        // 2. Act
        List<CharacterDTO> obtained = findService.find("Character");

        // 3. Assert
        Assertions.assertEquals(obtained.size(), characters.size());
        Assertions.assertEquals(obtained.get(0).getName(), characters.get(0).getName());
    }

}
