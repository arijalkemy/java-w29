package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {
    public List<Personaje>  personajes;
    public PersonajeRepository() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeReference = new TypeReference<List<Personaje>>() {};
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("3. c. starwars.json");

        try{
            personajes= mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el JSON",e);
        }
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
