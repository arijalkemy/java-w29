package dev.stars_wars.controller;

import dev.stars_wars.dto.PersonajeDto;
import dev.stars_wars.service.PersonajesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starswar")
public class PersonajeController {

    private final PersonajesService personajesService;

    public PersonajeController(PersonajesService personajesService) {
        this.personajesService = personajesService;
    }

    @GetMapping("/personaje/{name}")
    public ResponseEntity<List<PersonajeDto>> getPersonajesWithName(@PathVariable String name){
        return ResponseEntity.ok(personajesService.getNamesContains(name));
    }

}
