package com.meli.starwars.service;

import com.meli.starwars.dto.PersonajeDTO;
import com.meli.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    public PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeServiceImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        personajeRepository.getPersonajes().stream().filter(personaje -> personaje.name.contains(name)).forEach(
                personaje -> {
                    personajesDTO.add(new PersonajeDTO(personaje.gender,personaje.homeworld, personaje.height, personaje.mass, personaje.name, personaje.species));
                }
        );
        return personajesDTO;
    }

    @Override
    public List<PersonajeDTO> findAll() {
        List<PersonajeDTO> personajesDTO = new ArrayList<>();
        personajeRepository.getPersonajes().stream().forEach(
                personaje -> {
                    personajesDTO.add(new PersonajeDTO(personaje.gender,personaje.homeworld, personaje.height, personaje.mass, personaje.name, personaje.species));
                }
        );
        return personajesDTO;
    }
}

