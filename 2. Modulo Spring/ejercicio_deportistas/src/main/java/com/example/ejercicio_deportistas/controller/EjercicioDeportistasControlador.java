package com.example.ejercicio_deportistas.controller;

import com.example.ejercicio_deportistas.dto.DeportistaDTO;
import com.example.ejercicio_deportistas.model.Deporte;
import com.example.ejercicio_deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EjercicioDeportistasControlador {
    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public EjercicioDeportistasControlador() {
        Deporte voley = new Deporte("Voley", 1);
        Deporte tenis = new Deporte("Tenis", 1);
        Deporte futbol = new Deporte("Fútbol", 3);
        Deporte basquet = new Deporte("Basquet", 1);
        Deporte padel = new Deporte("Padel", 3);
        Deporte natacion = new Deporte("Natación", 1);
        Deporte hockey = new Deporte("Hockey", 1);
        Deporte rugby = new Deporte("Rugby", 3);
        Deporte futbol_americano = new Deporte("Fútbol Americano", 2);
        Deporte handball = new Deporte("Handball", 2);
        deportes.add(voley);
        deportes.add(tenis);
        deportes.add(futbol);
        deportes.add(basquet);
        deportes.add(padel);
        deportes.add(natacion);
        deportes.add(hockey);
        deportes.add(rugby);
        deportes.add(futbol_americano);
        deportes.add(handball);

        Persona daniel = new Persona("Daniel", "Ochoa", 23, futbol);
        Persona nicolas = new Persona("Nicolas", "Urrego", 31, basquet);
        Persona wilmer = new Persona("Wilmer", "Rodriguez", 22, natacion);
        personas.addAll(List.of(daniel, nicolas, wilmer));
    }

    @GetMapping("/findDeportes")
    public ResponseEntity<List<Deporte>> findDeportes() {
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findDeporte/{name}")
    public ResponseEntity<String> findDeporte(@PathVariable String name) {
        Deporte deporte = deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        return deporte == null
            ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el deporte de nombre: " + name)
            : ResponseEntity.ok("El nivel del deporte " + name + " es " + deporte.getNivel());
    }

    @GetMapping("/findDeportesPersons")
    public ResponseEntity<List<DeportistaDTO>> findDeportesPersons() {
        return ResponseEntity.ok(personas.stream().map(DeportistaDTO::new).toList());
    }
}
