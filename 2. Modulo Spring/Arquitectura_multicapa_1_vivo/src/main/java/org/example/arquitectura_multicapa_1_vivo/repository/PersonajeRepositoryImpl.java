package org.example.arquitectura_multicapa_1_vivo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.arquitectura_multicapa_1_vivo.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            personajes = mapper.readValue(
                    getClass().getResourceAsStream("/json/starwars.json"),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            personajes = List.of();
        }
    }


    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        return personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
}
