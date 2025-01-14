package com.mdaneri.arqmulticapap1vivo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.mdaneri.arqmulticapap1vivo.entity.Character;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileCharacterRepositoryImpl implements IFileCharacterRepository {

    private List<Character> characters = new ArrayList<>();

    public FileCharacterRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Character> characters;

        file = ResourceUtils.getFile("classpath:data.json");
        characters = objectMapper.readValue(file,new TypeReference<List<Character>>(){});

        this.characters = characters;
    }

}
