package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CharacterRepositoryTests {

    private CharacterRepositoryImpl repository;

    @BeforeEach
    void beforeEach() {
        repository = new CharacterRepositoryImpl();
    }

    @Test
    void charactersFileLoadsProperly() {
        assertDoesNotThrow(this::loadDataBase);
        assertFalse(loadDataBase().isEmpty());
    }

    @Test
    void findAllByNameContainsByFirstCharacter() {
        final List<CharacterDTO> characters = loadDataBase();
        final List<CharacterDTO> result = repository
                .findAllByNameContains(characters.getFirst().getName().substring(0, 1));

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void findAllByNameContainsByFullName() {
        final List<CharacterDTO> characters = loadDataBase();
        final List<CharacterDTO> result = repository
                .findAllByNameContains(characters.getFirst().getName());

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void findAllByNameContainsDataPersists() {
        final List<CharacterDTO> characters = loadDataBase();

        final CharacterDTO expectedCharacter = characters.getFirst();
        final CharacterDTO result = repository
                .findAllByNameContains(expectedCharacter.getName())
                .getFirst();

        assertEquals(expectedCharacter, result);
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {
        };
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
