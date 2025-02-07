package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterRepositoryImplTest {

    private CharacterRepository repository = new CharacterRepositoryImpl();

    @Test
    public void shouldFindCharacterByName() {
        // Arrange
        CharacterDTO characterDTO = Utils.createCharacterDTO();
        String query = "Luke";

        // Act
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        // Assert
        assertTrue(result.contains(characterDTO));
    }

}
