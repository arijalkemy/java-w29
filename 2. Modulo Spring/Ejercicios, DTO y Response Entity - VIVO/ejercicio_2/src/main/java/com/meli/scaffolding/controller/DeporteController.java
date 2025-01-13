package com.meli.scaffolding.controller;

import com.meli.scaffolding.models.Deporte;
import com.meli.scaffolding.models.Persona;
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
                    new Deporte("Futbol", 1),
                    new Deporte("Basquet", 1),
                    new Deporte("Padel", 1),
                    new Deporte("Natacion", 1),
                    new Deporte("Jockey", 1),
                    new Deporte("Rugby", 1),
                    new Deporte("Danza", 2),
                    new Deporte("Futbol Americano", 2),
                    new Deporte("Handball", 2),
                    new Deporte("Ping Pong", 2))
    );

    List<Persona> personas = new ArrayList<>(
            List.of(new Persona("Carolina", "Comba", 21),
                    new Persona("Francisco", "Comba", 14),
                    new Persona("Adriana", "Nivello", 51),
                    new Persona("Trinidad", "Comba", 26),
                    new Persona("Juan", "Perez", 21),
                    new Persona("María", "Rodríguez", 20),
                    new Persona("Pedro", "Gomez", 30))
    );

    @GetMapping("/findSports")
    public List<Deporte> findSports() {
        return deportes;
    }

    @GetMapping("/findSports/{name}")
    public Integer findSports(@PathVariable String name) {
        Deporte d = deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst().orElse(null);
        return d.getNivel();
    }



}
