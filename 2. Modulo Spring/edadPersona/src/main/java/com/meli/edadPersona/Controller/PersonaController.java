package com.meli.edadPersona.Controller;

import com.meli.edadPersona.Models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    List<Persona> personas = new ArrayList<>();

    @GetMapping("/{id}")
    public ResponseEntity<?> calcularEdad(@PathVariable Long id) {
        Persona persona = personas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        // Si la persona no se encuentra
        if (persona == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada con ID: " + id);
        }

        // Si la persona es encontrada, calcular la edad
        try {
            LocalDate fechaNacimiento = LocalDate.of(persona.getAnio(), persona.getMes(), persona.getDia());
            LocalDate fechaActual = LocalDate.now();

            Period periodo = Period.between(fechaNacimiento, fechaActual);
            int edad = periodo.getYears();

            return ResponseEntity.ok().body(edad);
        } catch (DateTimeException e) {
            return ResponseEntity.badRequest().body("La fecha de nacimiento no es correcta: " + e.getMessage());
        }
    }


    @PostMapping()
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        if(persona.getDia() < 1 || persona.getMes() < 1 || persona.getMes() > 12 || persona.getAnio() < 1){
            return ResponseEntity.badRequest().body(persona);
        }
        persona.setId((long) personas.size() + 1);
        personas.add(persona);
        return ResponseEntity.ok(persona);
    }

}
