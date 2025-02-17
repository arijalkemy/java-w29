package com.api.starwars.controller;

import com.api.starwars.dto.PersonajeDTO;
import com.api.starwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/starwars")
public class PersonajeController {
    private final PersonajeService service;

    public PersonajeController(PersonajeService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonajeDTO>> searchByName(@RequestParam String name) {
        try {
            List<PersonajeDTO> resultados = service.findByName(name);
            if (resultados.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(resultados);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDTO>> getAll() {
        try {
            List<PersonajeDTO> personajes = this.service.all();
            if (personajes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(personajes);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
