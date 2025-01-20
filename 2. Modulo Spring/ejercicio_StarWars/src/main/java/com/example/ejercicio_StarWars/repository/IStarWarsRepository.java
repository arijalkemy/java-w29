package com.example.ejercicio_StarWars.repository;

import com.example.ejercicio_StarWars.Entity.StarWars;

import java.util.List;

public interface IStarWarsRepository {
    List<StarWars> findByNameContaining(String name);
}
