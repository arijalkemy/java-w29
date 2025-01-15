package com.example.starwars.repositories;

import com.example.starwars.StarwarsApplication;
import com.example.starwars.entities.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    private List<Personaje> personajes;

    @PostConstruct
    private void init(){
        ObjectMapper MAPPER = new ObjectMapper();
        InputStream inputStream = StarwarsApplication.class.getResourceAsStream("/prueba.json");

        try {
            personajes = MAPPER.readValue(inputStream, new TypeReference<>() {});
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public List<Personaje> findAll() {
        return personajes;
    }
}
