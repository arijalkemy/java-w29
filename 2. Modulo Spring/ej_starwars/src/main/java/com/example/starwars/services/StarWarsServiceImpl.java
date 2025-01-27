package com.example.starwars.services;

import com.example.starwars.dtos.PersonajeDto;
import com.example.starwars.entities.Personaje;
import com.example.starwars.repositories.StarWarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarWarsServiceImpl implements StarWarsService {

    private final StarWarsRepository repo;

    @Override
    public List<PersonajeDto> getPersonajes(String nombre) {
        List<Personaje> personajes = repo.findAll();
        return personajes.stream().filter(p -> p.getName().contains(nombre)).map(PersonajeDto::toDto).toList();
    }

}
