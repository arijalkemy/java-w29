package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    private CharacterRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContainsTest() {
        String query = "Luke";
        List<CharacterDTO> characterDTOS = repository.findAllByNameContains(query);

        assertFalse(characterDTOS.isEmpty());
        assertTrue(characterDTOS.stream().allMatch(c -> c.getName().toUpperCase().contains(query.toUpperCase())));
    }
}