package com.api.starwars.repository;
import com.api.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepository {
    private final List<Personaje> personajes;

    public PersonajeRepository() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("starwars.json");
            if (inputStream == null) {
                throw new RuntimeException("Archivo starwars.json no encontrado en resources");
            }
            personajes = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo starwars.json", e);
        }
    }

    public List<Personaje> getAllPersonajes() {
        return personajes;
    }
}
