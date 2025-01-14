package com.example.star_wars_ejercicio.repository;


import com.example.star_wars_ejercicio.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository {
    private List<Personaje> personajes;

    //Cargo el json
    public StarWarsRepository() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream file = Personaje.class.getResourceAsStream("/static/starwars.json");
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};

        personajes = objectMapper.readValue(file, typeRef);
    }

    //NUNCA SE DEBE MANEJAR LA CONVERSION DEL OBJETO A SU DTO EN LA CAPA REPOSITORY
    public List<Personaje> encontrarPersonajes(String palabra){
        return personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(palabra.toLowerCase()))
                .collect(Collectors.toList());
    }
}
