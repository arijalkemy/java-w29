package com.org.meli.starwars.service;

import com.org.meli.starwars.dto.CharacterDto;

import java.util.List;

public interface IServiceCharacter {
    List<CharacterDto> findCharacterByName(String name);
}
