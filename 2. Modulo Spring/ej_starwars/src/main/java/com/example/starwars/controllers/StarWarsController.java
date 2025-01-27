package com.example.starwars.controllers;

import com.example.starwars.dtos.PersonajeDto;
import com.example.starwars.services.StarWarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StarWarsController {

    private final StarWarsService service;

    @GetMapping("/buscar/{name}")
    public ResponseEntity<List<PersonajeDto>> getPersonajes(@PathVariable String name) {
        return ResponseEntity.ok(service.getPersonajes(name));
    }

}
