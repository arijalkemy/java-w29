package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @ParameterizedTest
    @MethodSource("testFindAllByNameContains")
    @DisplayName("Find all characters by name query")
    void testFindAllByNameContains(String query, List<CharacterDTO> expectedCharacters) {
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedCharacters);
        List<CharacterDTO> result = findService.find(query);
        assertEquals(expectedCharacters, result, "Los personajes devueltos no coinciden con los esperados.");
    }


    static Stream<Arguments> testFindAllByNameContains() {
        CharacterDTO luke = new CharacterDTO("Luke Skywalker");
        CharacterDTO leia = new CharacterDTO("Leia Organa");
        CharacterDTO han = new CharacterDTO("Han Solo");
        CharacterDTO chewie = new CharacterDTO("Chewbacca");

        return Stream.of(
                Arguments.of("Luke", List.of(luke)),
                Arguments.of("a", List.of(luke, leia, han, chewie)),
                Arguments.of("Vader", List.of())
        );
    }
}
