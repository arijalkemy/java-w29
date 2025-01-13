package com.example.persona.controllers;

import com.example.persona.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final PersonaService service;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> obtenerEdad(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer anio
    ) {
        return ResponseEntity.ok(service.calcularEdad(dia, mes, anio));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
