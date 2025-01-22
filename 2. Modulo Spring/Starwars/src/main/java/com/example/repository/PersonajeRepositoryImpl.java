package com.example.repository;

import com.example.entities.Personaje;
import com.example.service.IPersonajeService;
import com.example.service.PersonajeServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    private List<Personaje> listOfPersonajes;
    private static final String FILE_PATH = "src/main/resources/personajes.json";
    private ObjectMapper objectMapper;

    public PersonajeRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public List<Personaje> getPersonajes() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("personajes.json")) {
            if (inputStream == null) {
                throw new RuntimeException("Archivo no encontrado: personajes.json");
            }
            return objectMapper.readValue(inputStream, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de personajes", e);
        }
    }


}
