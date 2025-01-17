package com.meli.scaffolding.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.scaffolding.dto.CharacterDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository{
    private final List<CharacterDto> database;

    public CharacterRepositoryImpl() {
        this.database = loadDataBase();
    }

    @Override
    public List<CharacterDto> findAllByNameContains(String query) {
        return database.stream()
                .filter(characterDto -> matchWith(query, characterDto))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, CharacterDto characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }


    private List<CharacterDto> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDto>> typeRef = new TypeReference<>() {};
        List<CharacterDto> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
