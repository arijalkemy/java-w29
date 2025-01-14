package com.bootcamp.starwars.repository;


import com.bootcamp.starwars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {
    private static final String JSON_FILE_PATH = "src/main/resources/static/starwars.json";
    private List<Character> characterList;
    public CharacterRepository(){
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
            ObjectMapper mapper = new ObjectMapper();
            characterList = mapper.readValue(jsonContent, mapper.getTypeFactory().constructCollectionType(List.class, Character.class));
        } catch (IOException ioException){
            ioException.printStackTrace();
            characterList = new ArrayList<>();
        }
    }
    public List<Character> getAllCharacters(){
        return characterList;
    }
    public List<Character> getCharacterByName(String name){
        return characterList.stream().filter(character -> character.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}
