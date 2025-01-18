package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository {

    private final List<Character> characters;

    public CharacterRepository() {
        this.characters = loadCharacters();
    }

    private List<Character> loadCharacters() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:db.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;

    }

    @Override
    public List<com.bootcamp.starwars.model.Character> findByName(String name) {
        return characters
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
