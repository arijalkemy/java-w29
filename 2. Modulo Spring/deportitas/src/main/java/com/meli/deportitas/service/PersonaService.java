package com.meli.deportitas.service;

import com.meli.deportitas.model.Persona;
import com.meli.deportitas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAllPersonas(){
        return personaRepository.getPersonas();
    }
}
