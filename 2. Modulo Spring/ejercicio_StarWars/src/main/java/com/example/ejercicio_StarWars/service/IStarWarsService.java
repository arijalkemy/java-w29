package com.example.ejercicio_StarWars.service;

import com.example.ejercicio_StarWars.Dto.StarWarsDto;


import java.util.List;

public interface IStarWarsService {
    List<StarWarsDto> getStarWars(String name);
}
