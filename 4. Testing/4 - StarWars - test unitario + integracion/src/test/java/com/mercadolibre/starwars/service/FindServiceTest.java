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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository characterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    void findTest(){
        // arrange
        String name = "Luke";
        CharacterDTO expected = CharacterDTO
                .builder()
                .name("Luke Skywalker")
                .height(172)
                .mass(77)
                .hair_color("blond")
                .skin_color("fair")
                .eye_color("blue")
                .birth_year("19BBY")
                .gender("male")
                .homeworld("Tatooine")
                .species("Human")
                .build();

        when(characterRepository.findAllByNameContains(name)).thenReturn(List.of(expected));

        // act
        List<CharacterDTO> actual = findService.find(name);

        // assert
        assertEquals(List.of(expected), actual);
        assertTrue(actual.contains(expected));
    }

    @Test
    void findTest_notOk(){
        // arrange
        String name = "name";

        when(characterRepository.findAllByNameContains(name)).thenReturn(List.of());

        // act
        List<CharacterDTO> actual = findService.find(name);

        // assert
        assertEquals(List.of(), actual);
        assertEquals(Integer.valueOf(0), actual.size());
    }
}
