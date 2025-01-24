package com.example.demo.repository;

import com.example.demo.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonajeRepository implements IPersonajeRepository{
    List<Personaje> listaPersonajes;

    public PersonajeRepository() throws IOException {
        cargarDatos();
    }

    @Override
    public Optional<List<Personaje>> encontrarPersonajes() {
        return Optional.ofNullable(listaPersonajes);
    }

    private void cargarDatos() throws IOException {
        File file = ResourceUtils.getFile("starwars.json");
        ObjectMapper objectMapper = new ObjectMapper();

        listaPersonajes = objectMapper.readValue(file, new TypeReference<>(){});
    }
}
