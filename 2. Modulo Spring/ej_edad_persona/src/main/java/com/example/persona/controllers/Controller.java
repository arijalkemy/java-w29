package com.example.persona.controllers;

import com.example.persona.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final PersonaService service;

    @Autowired
    public Controller(PersonaService service) {
        this.service = service;
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<?> obtenerEdad(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer anio
    ) {
        try {
            Integer edad = service.calcularEdad(dia, mes, anio);
            return ResponseEntity.ok(edad);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
