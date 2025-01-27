package com.meli.startwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.startwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRerepositoryImpl implements IPersonajeRepository{


    List<Personaje> personajesList;

    public PersonajeRerepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Personaje> fiendByName(String nombre) {
        return personajesList.stream()
                .filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }


    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Personaje> personajes ;

        file= ResourceUtils.getFile("classpath:starwars.json");
        personajes = objectMapper.readValue(file,new TypeReference<List<Personaje>>(){});

        personajesList = personajes;
    }
}



