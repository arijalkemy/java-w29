package com.StarWars.starwars.service;

import com.StarWars.starwars.dto.PersonajeDto;
import com.StarWars.starwars.entity.Personaje;

import java.util.List;

public interface IStarWarsService {

    List<PersonajeDto> searchCharacter(String name);
}
