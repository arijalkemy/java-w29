package com.example.ejercicio_StarWars.repository;

import com.example.ejercicio_StarWars.Entity.StarWars;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository {

    private List<StarWars> personajes;

    public StarWarsRepositoryImpl() {
        loadData();
    }

    private void loadData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            personajes = List.of(objectMapper.readValue(new File("src/main/resources/starwars.json"), StarWars[].class)); // Asegúrate de ajustar la ruta
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StarWars> findByNameContaining(String name) {
        return personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
