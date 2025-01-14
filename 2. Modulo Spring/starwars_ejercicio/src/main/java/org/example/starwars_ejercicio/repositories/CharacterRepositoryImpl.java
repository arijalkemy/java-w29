package org.example.starwars_ejercicio.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars_ejercicio.dto.CharacterDTO;
import org.example.starwars_ejercicio.models.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository{

    private List<Character> characters = new ArrayList<>();

    public CharacterRepositoryImpl() throws IOException{
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        System.out.println("Entrando al metodo");
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> charactersList ;

        file= ResourceUtils.getFile("src/main/resources/starwars.json");
        charactersList = objectMapper.readValue(file,new TypeReference<>(){});

        this.characters = charactersList;
    }

    @Override
    public List<Character> getAll() {
        return characters;
    }

    @Override
    public Character findById(Integer id) {
        return null;
    }

    @Override
    public CharacterDTO addCharacter(Character character) {
        return null;
    }

    @Override
    public List<Character> getCharacterByName(String word) {
        return getAll().stream().filter(c-> c.getName().toLowerCase().contains(word.toLowerCase())).toList();
    }
}
