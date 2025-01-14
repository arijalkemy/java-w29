package com.meli.ej_starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ej_starwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepositoryImpl() {
        this.loadDatabase();
    }

    private void loadDatabase() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/starwars.json");

        try {
            this.personajes = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }
}
