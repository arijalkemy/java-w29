package com.starwars.personajes.controller;

import com.starwars.personajes.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personajes")
public class PersonajeController {
    private IPersonajeService personajeService;

    @Autowired
    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonajesByName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.getPersonajesByName(name.toLowerCase()), HttpStatus.OK);
    }
}
