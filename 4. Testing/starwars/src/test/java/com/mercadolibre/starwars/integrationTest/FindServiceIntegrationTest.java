package com.mercadolibre.starwars.integrationTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FindServiceIntegrationTest {

    @Autowired
    private FindService findService;

    @Test
    void find_ShouldReturnMatchingCharacters() {
        List<CharacterDTO> result = findService.find("Darth");

        assertFalse(result.isEmpty());
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("Darth Vader")));
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("Darth Maul")));
    }

    @Test
    void find_ShouldReturnEmptyList_WhenNoMatches() {
        List<CharacterDTO> result = findService.find("UnknownCharacter");

        assertTrue(result.isEmpty());
    }
}
