package com.rest.edad.controllers;

import com.rest.edad.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Edad {
    List<Persona> listaPersonas = new ArrayList<>();

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());

        return periodo.getYears();
    }

    @PostMapping("/")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        listaPersonas.add(persona);
        System.out.println(persona.toString() + "-" + listaPersonas.size());
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }
}
