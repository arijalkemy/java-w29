package com.example.persona.controllers;

import com.example.persona.dtos.FechaNacimientoDto;
import com.example.persona.entities.Persona;
import com.example.persona.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persona")
public class Controller {

    private final PersonaService service;

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> obtenerEdad(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer anio
    ) {
        return ResponseEntity.ok(service.calcularEdad(dia, mes, anio));
    }

    @PostMapping
    public ResponseEntity<String> crearPersona(@RequestBody FechaNacimientoDto fechaNacimiento) {
        Persona persona = service.addPersona(fechaNacimiento);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(persona.getId());
        return ResponseEntity.created(location).body("Persona creada correctamente. ID: " + persona.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerPersona(@PathVariable Long id) {
        return ResponseEntity.ok(String.format("Edad: %s", service.getEdad(id)));
    }

}
