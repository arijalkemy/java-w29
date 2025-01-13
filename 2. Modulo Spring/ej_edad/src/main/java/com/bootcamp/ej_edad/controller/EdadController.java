package com.bootcamp.ej_edad.controller;

import com.bootcamp.ej_edad.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@RequestMapping("/edad")
public class EdadController {

    private List<Persona> personas = new ArrayList<>();

    @PostMapping("/{day}/{month}/{year}")
    public ResponseEntity<Persona> addPersona(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);
        Persona persona = new Persona(UUID.randomUUID(), fechaNacimiento);
        personas.add(persona);
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Long> getEdad(@PathVariable UUID id) {
        Persona persona = personas.stream().filter(p -> p.getIdPersona().equals(id)).findFirst().orElse(null);

        return ResponseEntity.ok(ChronoUnit.YEARS.between(persona.getFechaNacimiento(), LocalDate.now()));
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return ResponseEntity.ok(calcularEdad(day, month, year));
    }

    private Integer calcularEdad(int day, int month, int year) {
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);
        LocalDate fechaActual = LocalDate.now();
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        return (int) edad;
    }
}
