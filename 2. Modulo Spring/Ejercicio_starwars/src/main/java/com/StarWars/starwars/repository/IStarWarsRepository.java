package com.StarWars.starwars.repository;

import com.StarWars.starwars.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {

    List<Personaje> searchCharacter(String name);
}
