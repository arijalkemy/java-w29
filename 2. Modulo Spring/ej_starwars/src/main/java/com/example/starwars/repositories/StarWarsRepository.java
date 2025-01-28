package com.example.starwars.repositories;

import com.example.starwars.entities.Personaje;

import java.util.List;

public interface StarWarsRepository {
    List<Personaje> findAll();
}
