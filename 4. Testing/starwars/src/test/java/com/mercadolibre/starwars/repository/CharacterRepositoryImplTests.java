package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTests {

    private CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    void testFindAllByNameContains_FullMatch() {
        List<CharacterDTO> results = repository.findAllByNameContains("Luke");
        assertFalse(results.isEmpty());
        assertTrue(results.stream().allMatch(c -> c.getName().toUpperCase().contains("LUKE")));
    }

    @Test
    void testFindAllByNameContains_PartialMatch() {
        List<CharacterDTO> results = repository.findAllByNameContains("Skywalker");
        assertFalse(results.isEmpty());
        assertTrue(results.stream().allMatch(c -> c.getName().toUpperCase().contains("SKYWALKER")));
    }

    @Test
    void testFindAllByNameContains_CaseInsensitive() {
        List<CharacterDTO> resultsUpperCase = repository.findAllByNameContains("LUKE");
        List<CharacterDTO> resultsLowerCase = repository.findAllByNameContains("luke");
        assertEquals(resultsUpperCase, resultsLowerCase);
    }

    @Test
    void testFindAllByNameContains_NoMatch() {
        List<CharacterDTO> results = repository.findAllByNameContains("NonExistentCharacter");
        assertTrue(results.isEmpty());
    }
}
