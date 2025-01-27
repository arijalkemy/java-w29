package com.meli.deportistas.Controller;

import com.meli.deportistas.DTOs.PersonaDTO;
import com.meli.deportistas.entities.Deporte;
import com.meli.deportistas.entities.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/findSports")
public class DeportistaController {

    List<Deporte> deportes = List.of(
            new Deporte("Atletismo", "intermedio"),
            new Deporte("Futbol", "Avanzado"));

    List<Persona> personas = List.of(
            new Persona("jhon", "zuñiga", 27,
                    deportes.stream().filter(deporte -> deporte.getNombre().equals("Atletismo"))
                            .collect(Collectors.toList())),
            new Persona("Sebastian", "zuñiga", 27,
                    deportes.stream().filter(deporte -> deporte.getNombre().equals("Futbol"))
                            .collect(Collectors.toList())),
            new Persona("Pedro", "zuñiga", 27,
                    deportes.stream().filter(deporte -> deporte.getNombre().equals("Atletismo")
                            || deporte.getNombre().equals("Futbol"))
                            .collect(Collectors.toList()))

    );


    @GetMapping
    ResponseEntity<List<Deporte>> deportes(){
        return ResponseEntity.ok(deportes);
    }

    @GetMapping({"/{name}"})
    ResponseEntity<String> nivelDeDeporte(@PathVariable String name){
        return deportes.stream().filter(deporte -> deporte.getNombre().equals(name))
                .findFirst()
                .map(deporte -> ResponseEntity.ok(deporte.getNivel()))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/findSportPersons")
    ResponseEntity<List<PersonaDTO>> findSportPerson(){
        List<PersonaDTO> perosnasDTO = personas.stream()
                .map(persona -> new PersonaDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getDeportes().stream()
                                .map(Deporte::getNombre)
                                .collect(Collectors.toList())
                ))
                .toList();

        return ResponseEntity.ok(perosnasDTO);
    }


}
