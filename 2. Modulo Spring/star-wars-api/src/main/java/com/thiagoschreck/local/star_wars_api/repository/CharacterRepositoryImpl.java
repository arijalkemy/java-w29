package com.thiagoschreck.local.star_wars_api.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiagoschreck.local.star_wars_api.entity.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    private final List<Character> characters = getInitialCharactersData();

    @Override
    public List<Character> getAll() {
        return characters;
    }

    @Override
    public List<Character> getByName(String name) {
        return getAll().stream()
                .filter(character -> character.name().toLowerCase()
                        .startsWith(name.toLowerCase()))
                .toList();
    }

    private List<Character> getInitialCharactersData() {
        try {
            final File jsonFile = new ClassPathResource("starwars.json").getFile();
            final ObjectMapper objectMapper = new ObjectMapper();

            // Explicitly specify List<Character> type in TypeReference
            return objectMapper.readValue(jsonFile, new TypeReference<>() {
            });

        } catch (IOException e) {
            System.out.println("Could not find file!");
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
