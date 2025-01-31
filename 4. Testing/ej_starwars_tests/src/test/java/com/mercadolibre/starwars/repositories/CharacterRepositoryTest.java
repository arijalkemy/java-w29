package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryTest {

    CharacterRepositoryImpl repo;

    public CharacterRepositoryTest() throws IOException {
        repo = new CharacterRepositoryImpl();
    }

    @Test
    void testFindAllByNameContains() {
        // Act
        List<CharacterDTO> result = repo.findAllByNameContains("Luke");

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
