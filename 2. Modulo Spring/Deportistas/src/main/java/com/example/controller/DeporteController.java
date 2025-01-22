package com.example.controller;

import com.example.dto.PersonaDeportistaDTO;
import com.example.entities.Deporte;
import com.example.entities.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DeporteController {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

//PATH: /findSportsPersons
public DeporteController() {
    // Inicializar deportes y personas
    this.deportes = new ArrayList<>();
    this.deportes.add(new Deporte("Fútbol", "Alta"));
    this.deportes.add(new Deporte("Baloncesto", "Media"));
    this.deportes.add(new Deporte("Natación", "Baja"));

    this.personas = new ArrayList<>();
    this.personas.add(new Persona("Juan", "Pérez", 25, new Deporte("Fútbol", "Alta")));
    this.personas.add(new Persona("Ana", "García", 22, new Deporte("Natación", "Baja")));
    this.personas.add(new Persona("Luis", "Martínez", 30, new Deporte("Baloncesto", "Media")));
}
    @GetMapping("/findSportsPersons")
    public List<PersonaDeportistaDTO> findSportsPersons() {
        return personas.stream()
                .map(persona -> new PersonaDeportistaDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getDeporte().getNombre()
                ))
                .toList(); // Devuelve la lista de DTOs
    }

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addDeporte(@RequestBody Deporte deporte){
        deportes.add(deporte);
        return new ResponseEntity<>(deporte, HttpStatus.CREATED);
    }
    ///findSport/{name}
    @GetMapping
    public ResponseEntity<Deporte> findSport(@PathVariable String nombre) {
        Deporte deporte = deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
        if (deporte != null) {
            return ResponseEntity.ok(deporte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
