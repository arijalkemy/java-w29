package com.StarWars.starwars.repository;

import com.StarWars.starwars.dto.PersonajeDto;
import com.StarWars.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements IStarWarsRepository{
    private List<Personaje> listaPersonajes = new ArrayList<>();

    public StarWarsRepositoryImpl() throws IOException {
        loadDataBase();
    }


    private void loadDataBase() {
        try {
            File file = ResourceUtils.getFile("classpath:starwars.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Personaje> personajes = objectMapper.readValue(file, new TypeReference<List<Personaje>>() {});
            listaPersonajes = personajes;
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la base de datos desde el archivo JSON: " + e.getMessage(), e);
        }
    }
    @Override
    public List<Personaje> searchCharacter(String name) {
        return listaPersonajes.stream()
                .filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .toList();
    }
}
