package com.mercadolibre.starwars.unitTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.utilsTest.CharacterUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryImplTest {

    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContains_ShouldReturnMatchingCharacters() {
        // arrange & act
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Darth");

        List<CharacterDTO> expected = List.of(
                CharacterUtils.createCharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                        "male", "Tatooine", "Human", 202, 136),
                CharacterUtils.createCharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY",
                        "male", "Dathomir", "Zabrak", 175, 80)
        );


        // assertTrue(result.stream().anyMatch(c -> c.getName().equals("Darth Vader")));
        // assertTrue(result.stream().anyMatch(c -> c.getName().equals("Darth Maul")));

        // assert
        assertEquals(result, expected);
    }

    @Test
    void findAllByNameContains_ShouldReturnEmptyList_WhenNoMatches() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("UnknownCharacter");

        assertTrue(result.isEmpty());
    }
}
