package com.meli.deportistas.service;

import com.meli.deportistas.model.Persona;
import com.meli.deportistas.repository.PersonaRepository;
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
