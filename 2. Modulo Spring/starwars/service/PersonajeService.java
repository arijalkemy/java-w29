package com.api.starwars.service;

import com.api.starwars.dto.PersonajeDTO;
import com.api.starwars.entity.Personaje;
import com.api.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final PersonajeRepository repository;

    public PersonajeService(PersonajeRepository repository) {
        this.repository = repository;
    }
    public List<PersonajeDTO> all() {
        return repository.getAllPersonajes().stream().map(
                personaje -> new PersonajeDTO(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                ))
                .toList();
    }

    public List<PersonajeDTO> findByName(String name) {
        return repository.getAllPersonajes().stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase()))
                .map(personaje -> new PersonajeDTO(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                ))
                .toList();
    }
}
