package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository;

    public CharacterRepositoryImplTest()  {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    public void testFindAllByNameContains() {
        String query = "Luke";

        List<CharacterDTO> result = repository.findAllByNameContains(query);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}
