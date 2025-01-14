package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.model.Personaje;
import com.example.demo.repository.PersonajeRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements PersonajeService {
    private final PersonajeRepositoryImp personajeRepository;

    public PersonajeServiceImp(PersonajeRepositoryImp personajeRepository) {
        this.personajeRepository = personajeRepository;
    }


    @Override
    public List<PersonajeDTO> findByNombre(String n) {
        ObjectMapper om = new ObjectMapper();

        List<Personaje> personajes = personajeRepository.findAll();
        return personajes
                .stream()
                .filter(p -> p.getName().toLowerCase().contains(n.toLowerCase()))
                .map(p -> om.convertValue(p, PersonajeDTO.class)).
                collect(Collectors.toList());
    }
}
