package com.example.p1.controller;

import com.example.p1.entity.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class PersonController {
    HashMap<Integer, Persona> personas = new HashMap<>();
    int contador = 0;

    @PostMapping("/addPerson")
    public ResponseEntity<?> addPerson(@RequestBody Persona persona) {
        personas.put(contador,persona);
        contador++;
        return ResponseEntity.ok().body(persona);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable Integer id) {
        if (personas.containsKey(id)) {
            Persona persona = personas.get(id);
            return ResponseEntity.ok(persona); // Si se encuentra, devuelves la persona
        } else {
            return ResponseEntity.notFound().build(); // Si no se encuentra, devuelves 404
        }
    }
}
