package com.meli.ej_starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ej_starwars.dto.PersonajeDTO;
import com.meli.ej_starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    private final PersonajeRepository personajeRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PersonajeServiceImpl(
            PersonajeRepository personajeRepository,
            ObjectMapper objectMapper) {
        this.personajeRepository = personajeRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<PersonajeDTO> findAllPersonajesByName(String name) {
        return this.personajeRepository.findAllByName(name).stream()
                .map(personaje -> this.objectMapper.convertValue(personaje, PersonajeDTO.class))
                .toList();
    }
}
