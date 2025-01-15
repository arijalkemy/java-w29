package org.example.ej_starwars.Service;

import org.example.ej_starwars.Dto.PersonajeDto;

import java.util.List;

public interface IPersonajService {
    List<PersonajeDto> findByName(String name);
}
