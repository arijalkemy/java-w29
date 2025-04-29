package com.StarWars.starwars.service;

import com.StarWars.starwars.dto.PersonajeDto;
import com.StarWars.starwars.entity.Personaje;
import com.StarWars.starwars.repository.IStarWarsRepository;
import com.StarWars.starwars.repository.StarWarsRepositoryImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarWarServiceImpl implements IStarWarsService {
    private final IStarWarsRepository starWarsRepository;
    private final ObjectMapper objectMapper;


    public StarWarServiceImpl(StarWarsRepositoryImpl starWarsRepository){
        this.starWarsRepository = starWarsRepository;
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Override
    public List<PersonajeDto> searchCharacter(String name) {
        List<Personaje> personajes = starWarsRepository.searchCharacter(name);
        List<PersonajeDto> personajesDto;
        try {
            personajesDto = objectMapper.convertValue(personajes, new TypeReference<List<PersonajeDto>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir personajes a DTO: " + e.getMessage(), e);
        }
        return personajesDto;
    }
}
