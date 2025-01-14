package com.bootcamp.ej_covid_19.controller;

import com.bootcamp.ej_covid_19.dto.PersonaDTO;
import com.bootcamp.ej_covid_19.model.Persona;
import com.bootcamp.ej_covid_19.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hospital/")
public class HospitalController {
    List<Sintoma> sintomas = Arrays.asList(
            new Sintoma(1, "Tos", 6),
            new Sintoma(2, "Fiebre", 4),
            new Sintoma(3, "Fatiga", 2),
            new Sintoma(4, "Dolor de garganta", 10)
    );

    List<Persona> personas = Arrays.asList(
            new Persona(1, "Jorge Luis", "Borges", 126),
            new Persona(2, "Lionel Andres", "Messi", 36),
            new Persona(3, "Jose", "San Martin", 246)
    );

    @GetMapping("findSymptom")
    public ResponseEntity<List<Sintoma>> findSymptom() {
        return ResponseEntity.ok(sintomas);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<Integer> findSymptom(@PathVariable String name) {
        Optional<Sintoma> sintoma = sintomas.stream()
                .filter(s -> name.equalsIgnoreCase(s.getNombre()))
                .findFirst();
        
        return sintoma.map(s -> ResponseEntity.ok(s.getNivelDeGravedad()))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPerson() {
        List<PersonaDTO> respuesta = personas.stream().filter(persona -> persona.getEdad() > 60)
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido())).toList();

        return respuesta.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(respuesta);
    }

}
