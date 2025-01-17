package com.ejercicio.deportistas.controller;

import com.ejercicio.deportistas.model.Deporte;
import com.ejercicio.deportistas.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {

    private Deporte d1 = new Deporte("Futbol", "Avanzado");
    private Deporte d2 = new Deporte("Basquet", "Medio");
    private Deporte d3 = new Deporte("Golf", "Bajo");
    private Persona p1 = new Persona("Camilo", "Mendez", 22, d1);
    private Persona p2 = new Persona("Pepito", "Perez", 40, d2);
    private Persona p3 = new Persona("Daniela", "Castro", 55, d3);

    private final List<Deporte> deportes =  List.of(d1, d2, d3);
    private final List<Persona> personas = List.of(p1, p2, p3);

    @GetMapping("/findSports")
    public ResponseEntity<?> getAllDeportes() {
        return new ResponseEntity<>(this.deportes, HttpStatus.OK);
    }


    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        Optional<Deporte> deporte = this.deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst();;
        if (deporte.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deporte, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons() {
        return new ResponseEntity<>(this.personas, HttpStatus.OK);
    }

}
