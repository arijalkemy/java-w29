package com.spring.star_wars.repository;

import com.spring.star_wars.model.SWCharacter;

import java.util.List;

public interface StarWarsRepository {
    public List<SWCharacter> getCharactersNamed(String partialName);
}
