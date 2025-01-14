package com.example.star_wars_ejercicio.service;

import com.example.star_wars_ejercicio.dto.PersonajeDTO;
import com.example.star_wars_ejercicio.repository.StarWarsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StarWarsService {
    StarWarsRepository starWarsRepository;

    public StarWarsService(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    public List<PersonajeDTO> buscarPersonajes(String nombre){
        return starWarsRepository.encontrarPersonajes(nombre)
                .stream()
                .map(personaje -> new PersonajeDTO(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()))
                .collect(Collectors.toList());
    }
}
