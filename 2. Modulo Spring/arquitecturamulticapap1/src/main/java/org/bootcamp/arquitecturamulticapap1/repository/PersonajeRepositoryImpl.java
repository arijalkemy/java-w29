package org.bootcamp.arquitecturamulticapap1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.arquitecturamulticapap1.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    private final List<Personaje> personajes;

    private static final String JSON_PATH = "src/main/resources/static/starwars.json";

    public PersonajeRepositoryImpl() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            personajes = objectMapper.readValue(
                    new File(JSON_PATH),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Personaje> getPersonajeByName(String name) {
        return personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
