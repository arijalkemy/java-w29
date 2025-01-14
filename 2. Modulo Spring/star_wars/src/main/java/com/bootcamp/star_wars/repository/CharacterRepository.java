package com.bootcamp.star_wars.repository;

import com.bootcamp.star_wars.entity.Character;

import java.util.List;

public interface CharacterRepository {

    List<Character> findByName(String name);
}
