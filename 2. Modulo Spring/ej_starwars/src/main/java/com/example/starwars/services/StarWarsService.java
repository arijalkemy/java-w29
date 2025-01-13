package com.example.starwars.services;

import com.example.starwars.dtos.PersonajeDto;

import java.util.List;

public interface StarWarsService {

    List<PersonajeDto> getPersonajes(String nombre);

}
