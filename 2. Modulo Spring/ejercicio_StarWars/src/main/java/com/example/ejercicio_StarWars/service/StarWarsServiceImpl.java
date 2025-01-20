package com.example.ejercicio_StarWars.service;

import com.example.ejercicio_StarWars.Dto.StarWarsDto;
import com.example.ejercicio_StarWars.Entity.StarWars;

import com.example.ejercicio_StarWars.repository.StarWarsRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements IStarWarsService {

    private final StarWarsRepositoryImpl repository;

    public StarWarsServiceImpl(StarWarsRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<StarWarsDto> getStarWars(String name) {
        return repository.findByNameContaining(name)
                .stream()
                .map(character -> new StarWarsDto(
                        character.getName(),
                        character.getHeight(),
                        character.getMass(),
                        character.getGender(),
                        character.getHomeworld(),
                        character.getSpecies()
                ))
                .collect(Collectors.toList());
    }
}