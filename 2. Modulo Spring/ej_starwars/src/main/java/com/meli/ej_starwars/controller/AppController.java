package com.meli.ej_starwars.controller;


import com.meli.ej_starwars.model.Personaje;
import com.meli.ej_starwars.service.PersonajeService;
import com.meli.ej_starwars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    private final PersonajeService personajeService;

    @Autowired
    public AppController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personaje/{name}")
    public ResponseEntity<List<Personaje>> getPersonajes(@PathVariable String name) {
        return ResponseEntity.ok(this.personajeService.findAllPersonajesByName(name));
    }
}
