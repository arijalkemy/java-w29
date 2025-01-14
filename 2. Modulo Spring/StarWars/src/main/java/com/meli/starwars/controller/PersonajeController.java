package com.meli.starwars.controller;

import com.meli.starwars.dto.PersonajeDTO;
import com.meli.starwars.model.Personaje;
import com.meli.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/personajes")
public class PersonajeController {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajesByName(@PathVariable String name) {
        return ResponseEntity.ok(this.personajeService.searchByName(name));
    }

}
