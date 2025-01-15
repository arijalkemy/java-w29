package com.mercadolibre.javawave29.star_wars.repository;

import com.mercadolibre.javawave29.star_wars.model.StarWarsCharacter;

import java.util.List;

public interface IRepository {
    List<StarWarsCharacter> getCharacters ();
    List<StarWarsCharacter> getCharactersByName (String name);

    boolean save(StarWarsCharacter character);
}
