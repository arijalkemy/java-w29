package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    public void findTest() {
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setHair_color("Blond");
        luke.setSkin_color("Fair");
        luke.setEye_color("Blue");
        luke.setBirth_year("19BBY");
        luke.setGender("Male");
        luke.setHomeworld("Tatooine");
        luke.setSpecies("Human");
        luke.setHeight(172);
        luke.setMass(77);

        List<CharacterDTO> expected = List.of(luke);

        when(repository.findAllByNameContains(anyString())).thenReturn(expected);

        List<CharacterDTO> actual = service.find("query");

        verify(repository, atLeastOnce()).findAllByNameContains("query");

        Assertions.assertEquals(expected, actual);
    }

}
