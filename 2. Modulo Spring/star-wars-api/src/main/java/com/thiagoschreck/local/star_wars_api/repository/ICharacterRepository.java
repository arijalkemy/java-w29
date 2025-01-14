package com.thiagoschreck.local.star_wars_api.repository;

import com.thiagoschreck.local.star_wars_api.entity.Character;

import java.util.List;

public interface ICharacterRepository {

    List<Character> getByName(String name);

    List<Character> getAll();
}
