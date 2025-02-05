package com.meli.starwars.controller;

import com.meli.starwars.dto.PersonajeDTO;
import com.meli.starwars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    public PersonajeServiceImpl personajeService;
    @Autowired
    public PersonajeController(PersonajeServiceImpl personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public List<PersonajeDTO> getPersonaje() {
        return personajeService.findAll();
    }

    @GetMapping("/personajes/{name}")
    public List<PersonajeDTO> getPersonaje(@PathVariable String name) {
        return personajeService.findByName(name);
    }
}
