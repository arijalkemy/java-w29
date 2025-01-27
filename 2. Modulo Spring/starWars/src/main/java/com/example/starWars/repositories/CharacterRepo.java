package com.example.starWars.repositories;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.starWars.entities.Character;

@Repository
public class CharacterRepo {
    private static List<Character> characters;

    public CharacterRepo(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = CharacterRepo.class.getClassLoader().getResourceAsStream("starwars.json");
            CharacterRepo.characters = mapper.readValue(inputStream, new TypeReference<List<Character>>(){});
            System.out.println(characters.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Character> getCharacters() {
        return CharacterRepo.characters;
    }
}
