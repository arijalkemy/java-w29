package com.bootcamp.star_wars.repository;

import com.bootcamp.star_wars.entity.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private final String STAR_WARS_JSON_PATH = "src/main/resources/starwars_characters.json";
    private List<Character> characters;

    public CharacterRepositoryImpl() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonContent = Files.readString(Paths.get(STAR_WARS_JSON_PATH));
            characters = mapper.readValue(jsonContent, new TypeReference<>() {});
        }catch (Exception e){
            characters = List.of();
        }
    }

    @Override
    public List<Character> findByName(String name) {
        return characters.stream().filter(character -> character.getName().toLowerCase()
                .contains(name.toLowerCase())).toList();
    }
}
