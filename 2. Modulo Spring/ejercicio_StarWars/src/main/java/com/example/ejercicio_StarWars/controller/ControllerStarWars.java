package com.example.ejercicio_StarWars.controller;

import com.example.ejercicio_StarWars.service.IStarWarsService;
import com.example.ejercicio_StarWars.service.StarWarsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerStarWars {
    private final IStarWarsService service;

    public ControllerStarWars(StarWarsServiceImpl service) {
        this.service = service;
    }

    @GetMapping("nombre/{name}")
    public ResponseEntity<?> getStarWars(@PathVariable String name) {
        return ResponseEntity.ok(service.getStarWars(name));
    }
}
