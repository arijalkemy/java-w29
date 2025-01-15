package com.example.service;

import com.example.dto.PersonajeDto;
import com.example.entities.Personaje;
import com.example.repository.IPersonajeRepository;
import com.example.repository.PersonajeRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    private IPersonajeRepository personajeRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public PersonajeServiceImpl(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDto> searchAllPersonajes() {
        List<Personaje> personajes = personajeRepository.getPersonajes();
        return personajes.stream()
                .map(x -> mapper.convertValue(x, PersonajeDto.class))
                .collect(Collectors.toList());
    }
}
