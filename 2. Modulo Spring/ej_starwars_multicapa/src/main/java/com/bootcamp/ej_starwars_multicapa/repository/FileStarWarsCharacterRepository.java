package com.bootcamp.ej_starwars_multicapa.repository;

import com.bootcamp.ej_starwars_multicapa.model.StarWarsCharacter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileStarWarsCharacterRepository implements IStarWarsCharacterRepository {

    List<StarWarsCharacter> characters = new ArrayList<>();

    public FileStarWarsCharacterRepository() {
        loadCharacters();
    }

    @Override
    public void loadCharacters() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inJson = StarWarsCharacter.class.getResourceAsStream("/static/starwars_characters.json");
            TypeReference<List<StarWarsCharacter>> typeRef = new TypeReference<>() {};

            characters = mapper.readValue(inJson, typeRef);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            // e.printStackTrace();
        }
    }

    @Override
    public List<StarWarsCharacter> searchCharacter(String query) {
        return characters.stream()
                .filter(character -> character.getName().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}
