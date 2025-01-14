package com.practicaejerciciodcovid.practicacovid.controllers;

import com.practicaejerciciodcovid.practicacovid.DTO.PersonaDto;
import com.practicaejerciciodcovid.practicacovid.model.Persona;
import com.practicaejerciciodcovid.practicacovid.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/consultas-covid")
public class SintomasRestController {

    //definición de listas para almacenar los datos precargados
    private final List<Sintoma> sintomas = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();

    //constructor con datos precargados en memoria
    public SintomasRestController() {
        sintomas.add(new Sintoma("0011", "Fiebre", "Alto"));
        sintomas.add(new Sintoma("0022", "Agitacion", "Alto"));
        sintomas.add(new Sintoma("0033", "Falta de respiración", "Alto"));

        personas.add(new Persona("Luis", "Jaimes", 25, 1, sintomas.get(0)));
        personas.add(new Persona("John", "Sepúlveda", 65, 2,  sintomas.get(2)));
        personas.add(new Persona("Maria", "Galvis", 71, 3,  sintomas.get(1)));
        personas.add(new Persona("Andrea", "Quiceno", 32, 4,  sintomas.get(1)));

    }

    // Ver todos los sintomas cargados
    @GetMapping("/findSymptom")
    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    //Consultar un sintoma por su nombre
    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<Sintoma> getSintoma(@PathVariable String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Sintoma sintoma = sintomas.stream()
                .filter(s -> s.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        if (sintoma == null) {
            return ResponseEntity.status(404).body(null);
        }

        return ResponseEntity.ok(sintoma);
    }

    //Ver personas con riesgo de Covid, teniendo en cuenta que sea mayores de 60 años
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> getPersonasConSintomas() {
        List<PersonaDto> personasConRiesgo = personas.stream()
                .filter(ps -> ps.getEdad() > 60 && ps.getSintoma() != null)
                .map(ps -> new PersonaDto(ps.getNombre(), ps.getApellido(), ps.getEdad(), ps.getSintoma().getNombre()))
                .collect(Collectors.toList());

        if (personasConRiesgo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personasConRiesgo);
        }

        return ResponseEntity.ok(personasConRiesgo);
    }
}
