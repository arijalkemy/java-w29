package com.bootcamp.ej_deportistas.controller;

import com.bootcamp.ej_deportistas.dto.PersonaDTO;
import com.bootcamp.ej_deportistas.model.Deporte;
import com.bootcamp.ej_deportistas.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/deporte/")
public class DeporteController {

    List<Deporte> deportes = Arrays.asList(
            new Deporte("Futbol", 2),
            new Deporte("Tenis", 4),
            new Deporte("Ajedrez", 5)
    );

    List<Persona> personas = Arrays.asList(
            new Persona("Lucas", "Rodriguez", 31, deportes.getFirst()),
            new Persona("German", "Beder", 41, deportes.get(1)),
            new Persona("Roberto", "Galatti", 42, deportes.get(2))
    );

    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Integer> findSportByName(@PathVariable("name") String name) {
        return deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst()
                .map(value -> ResponseEntity.ok(value.getNivel()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons() {
        List<PersonaDTO> respuesta = personas.stream()
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

}
