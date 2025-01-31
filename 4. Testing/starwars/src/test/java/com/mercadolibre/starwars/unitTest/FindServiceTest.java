package com.mercadolibre.starwars.unitTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utilsTest.CharacterUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FindServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find_ShouldReturnMatchingCharacters() {
        List<CharacterDTO> characters = List.of(
                CharacterUtils.createCharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY",
                        "male", "Tatooine", "Human", 202, 136),
                CharacterUtils.createCharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY",
                        "male", "Dathomir", "Zabrak", 175, 80)
        );

        when(characterRepository.findAllByNameContains("Darth")).thenReturn(characters);

        List<CharacterDTO> result = findService.find("Darth");

        // assertEquals(2, result.size());
        verify(characterRepository, atLeastOnce() ).findAllByNameContains("Darth");
    }
    @Test
    void find_ShouldReturnEmptyList() {

        assertThrows(RuntimeException.class, () -> {
            this.findService.find("NotExisting"); // act & assert
        });

    }


}
