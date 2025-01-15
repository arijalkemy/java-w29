package com.example.starWarsCharacters.repository;

import com.example.starWarsCharacters.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository {
    private List<Character> characters;

    public CharacterRepository() {
        readJsonFile();
    }

    @Override
    public void addCharacter(Character character) {
        characters.add(character);
    }

    @Override
    public List<Character> getCharacterByName(String name) {
        return characters.stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }


    /**
     * Read json file and put into list of character
     */
    private void readJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("starwars.json");
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            characters = objectMapper.readValue(inputStream, new TypeReference<List<Character>>() {});
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
