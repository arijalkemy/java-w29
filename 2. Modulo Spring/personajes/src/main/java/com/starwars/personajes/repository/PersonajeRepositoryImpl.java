package com.starwars.personajes.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.personajes.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {
    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("starwars.json");
            ObjectMapper mapper = new ObjectMapper();
            if (inputStream != null) {
                personajes = mapper.readValue(inputStream, new TypeReference<List<Personaje>>() {
                });
            } else {
                throw new FileNotFoundException("Archivo no encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> getPersonajesByName(String name) {
        return personajes.stream().filter(p -> p.getName().toLowerCase().contains(name)).toList();
    }
}
