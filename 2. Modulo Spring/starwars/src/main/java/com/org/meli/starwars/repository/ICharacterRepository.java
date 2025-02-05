package com.org.meli.starwars.repository;

import com.org.meli.starwars.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> findCharacterByName(String name);
}
