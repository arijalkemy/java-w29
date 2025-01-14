package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{
    private List<Personaje> personajes;
    private static final String JSON_FILE_PATH = "src/main/resources/starwars.json";

    public PersonajeRepositoryImpl() {
        this.cargarDatos();
    }

    private void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonContent = Files.readString(Paths.get(JSON_FILE_PATH));
            personajes = objectMapper.readValue(jsonContent, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            personajes = List.of();
        }
    }

    @Override
    public List<Personaje> obtenerCoincidenciaPorNombre(String cadena) {
        return personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(cadena.toLowerCase()))
                .collect(Collectors.toList());
    }
}
