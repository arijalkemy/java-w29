package com.bootcamp.ej_starwars_multicapa.repository;

import com.bootcamp.ej_starwars_multicapa.model.StarWarsCharacter;

import java.util.List;

public interface IStarWarsCharacterRepository {
    void loadCharacters();
    List<StarWarsCharacter> searchCharacter(String query);
}
