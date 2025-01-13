package com.mdaneri.dtoresponseentityvivo2.controllers;

import com.mdaneri.dtoresponseentityvivo2.dtos.DeportistaDTO;
import com.mdaneri.dtoresponseentityvivo2.models.Deporte;
import com.mdaneri.dtoresponseentityvivo2.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class DeportistasController {

    private List<Deporte> deportes;
    private List<Persona> personas;
    private Map<Deporte, List<Persona>> personasByDeporte;

    public DeportistasController() {
        this.deportes = new ArrayList<>();
        this.personas = new ArrayList<>();
        this.personasByDeporte = new HashMap<>();

        personas.add(new Persona("Matías", "Alfonso", 26));
        personas.add(new Persona("Lucas", "Ricardo", 30));
        deportes.add(new Deporte("Correr", 1));
        deportes.add(new Deporte("Patin", 2));
        personasByDeporte.put(deportes.get(0), new ArrayList<>());
        personasByDeporte.put(deportes.get(1), new ArrayList<>());
        personasByDeporte.get(deportes.get(0)).add(personas.get(0));
        personasByDeporte.get(deportes.get(0)).add(personas.get(1));
        personasByDeporte.get(deportes.get(1)).add(personas.get(1));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findAll() {
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{sportName}")
    public ResponseEntity<String> findSport(@PathVariable String sportName) {
        Optional<Deporte> sports = deportes.stream().filter(s -> s.getNombre().equals(sportName)).findFirst();
        return sports.map(deporte -> new ResponseEntity<>(deporte.getNivel().toString(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("No se encontró un deporte con ese nombre", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findPersons() {
        List<DeportistaDTO> deportistasDTOS = new ArrayList<>();
        for (Deporte d : personasByDeporte.keySet()) {
            for (Persona p : personasByDeporte.get(d)) {
                deportistasDTOS.add(new DeportistaDTO(p.getNombre(), p.getApellido(), d.getNombre()));
            }
        }
        return new ResponseEntity<>(deportistasDTOS, HttpStatus.OK);
    }

}
