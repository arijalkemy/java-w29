package com.starwars.starwars.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.model.Personaje;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository{


    @Override
    public List<Personaje> getAllPersonajes() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> persons = new ArrayList<Personaje>();
        // Load JSON file from resources
        try (InputStream inputStream = getClass().getResourceAsStream("/starwars.json")) {
            if (inputStream != null) {
                persons = objectMapper.readValue(inputStream, new TypeReference<List<Personaje>>() {});
            } else {
                throw new IOException("Unable to find file in resources");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Personaje getPersonajeByName(String name) {
        return null;
    }

    @Override
    public void addPersonaje(Personaje character) {
    }

    @Override
    public void updatePersonaje(Personaje character) {
    }

    @Override
    public void deletePersonaje(Personaje character) {
    }

}
