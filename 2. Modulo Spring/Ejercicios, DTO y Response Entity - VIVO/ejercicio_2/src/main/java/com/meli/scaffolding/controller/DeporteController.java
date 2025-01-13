package com.meli.scaffolding.controller;

import com.meli.scaffolding.models.Deporte;
import com.meli.scaffolding.models.Persona;
import com.meli.scaffolding.models.PersonaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {
    List<Deporte> deportes = new ArrayList<>(
            List.of(new Deporte("Voley", 1),
                    new Deporte("Tenis", 1),
                    new Deporte("Futbol", 3),
                    new Deporte("Basquet", 1),
                    new Deporte("Padel", 3),
                    new Deporte("Natacion", 1),
                    new Deporte("Jockey", 1),
                    new Deporte("Rugby", 3),
                    new Deporte("Futbol Americano", 2),
                    new Deporte("Handball", 2),
                    new Deporte("Ping Pong", 2))
    );

    List<PersonaDTO> personaDTOS = new ArrayList<>(
            List.of(new PersonaDTO("Carolina", "Comba", "Tenis"),
                    new PersonaDTO("Alejandro", "Díaz", "Padel"),
                    new PersonaDTO("Elias", "Juarez", "Voley"))
    );

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Integer> findSports(@PathVariable String name) {
        Deporte d = deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().orElse(null);
        return ResponseEntity.ok(d.getNivel());
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> findSportsPersons() {
        return personaDTOS;
    }



}
