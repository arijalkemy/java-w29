package org.example.ej_starwars.Controller;

import org.example.ej_starwars.Dto.PersonajeDto;
import org.example.ej_starwars.Entity.Personaje;
import org.example.ej_starwars.Service.PersonajeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/starwars")
public class PersonajeController {


    private final PersonajeServiceImpl service;

    public PersonajeController(PersonajeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/personajes/{name}")
    public ResponseEntity<List<PersonajeDto>> getPersonaje(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
}
