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
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> characterList ;
        file= ResourceUtils.getFile("classpath:starwars.json");
        characterList= objectMapper.readValue(file,new TypeReference<List<Character>>(){});

        this.characters = characterList;
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
}
