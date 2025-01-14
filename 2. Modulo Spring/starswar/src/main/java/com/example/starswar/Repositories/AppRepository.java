package com.example.starswar.Repositories;

import com.example.starswar.Models.Characterer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

@Repository
public class AppRepository implements IAppRepository {

    public List<Characterer> readStarWarsData() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Characterer> characters = null;

        try {
            String path = "/Users/pviano/Documents/Bootcamp_Java/starswar/src/main/java/com/example/starswar/Repositories/starwars.json";
            String json = new String(Files.readAllBytes(Paths.get(path)));
            characters = objectMapper.readValue(json, new TypeReference<List<Characterer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

}
