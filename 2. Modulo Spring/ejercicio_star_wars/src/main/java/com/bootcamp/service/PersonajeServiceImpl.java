package com.bootcamp.service;

import com.bootcamp.dto.PersonajeDto;
import com.bootcamp.exception.PersonajeNotFound;
import com.bootcamp.model.Personaje;
import com.bootcamp.repository.IPersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDto> findByText(String text) {
        List<Personaje> personajes = personajeRepository.findByText(text);
        if (personajes.isEmpty()) {
            throw new PersonajeNotFound("No se han encotrado persoanes");
        }
        ObjectMapper mapper = new ObjectMapper();
        return personajes.stream()
                .map(p -> mapper.convertValue(p, PersonajeDto.class))
                .toList();
    }

}
