package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.exceptions.DataLoadException;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private List<CharacterDTO> database;

    public CharacterRepositoryImpl() throws IOException {
        this.database = loadDataBase();
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query) {
        return database.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
                .collect(Collectors.toList());
    }

    public List<CharacterDTO> loadDataBase() throws IOException {
        File file = ResourceUtils.getFile("classpath:starwars_characters.json");
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        return new ObjectMapper().readValue(file, typeRef);
    }

    private boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }
}
