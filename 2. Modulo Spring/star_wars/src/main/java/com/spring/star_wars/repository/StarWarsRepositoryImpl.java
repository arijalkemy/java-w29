package com.spring.star_wars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.star_wars.model.SWCharacter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {
    private final List<SWCharacter> characters = getJSONCharacters();

    @Override
    public List<SWCharacter> getCharactersNamed(String partialName) {
        return characters.stream()
                .filter((c) -> {
                    System.out.println(c + " and " + partialName);
                    return c.name().contains(partialName);
                })
                .toList();
    }

    public List<SWCharacter> getCharacters() {
        return characters;
    }

    private List<SWCharacter> getJSONCharacters() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Resource resource = new ClassPathResource("star_wars.json");
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<List<SWCharacter>>() {});
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
