package com.thiagoschreck.local.calculadora_edad.controller;

import com.thiagoschreck.local.calculadora_edad.model.Persona;
import com.thiagoschreck.local.calculadora_edad.service.CalculadoraDeEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/edad")
public class CalculadoraDeEdadController {

    @Autowired
    private CalculadoraDeEdadService calculadoraDeEdadService;

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable Integer day,
                                                @PathVariable Integer month,
                                                @PathVariable Integer year) {
        return ResponseEntity.ok(calculadoraDeEdadService.calcular(new Persona.FechaDeNacimiento(day, month, year)));
    }

    @PostMapping("/personas")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(calculadoraDeEdadService.agregarPersona(persona));
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> buscarPersonaPorId(@PathVariable Integer id) {
        Persona persona = calculadoraDeEdadService.buscarPersona(id);
        if (persona == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(persona);
    }

    @PostMapping("/personas/buscar")
    public ResponseEntity<List<Persona>> buscarPersonaPorFechaDeNacimiento(@RequestBody Persona.FechaDeNacimiento fechaDeNacimiento) {
        return ResponseEntity.ok(calculadoraDeEdadService.buscarPersonas(fechaDeNacimiento));
    }
}
