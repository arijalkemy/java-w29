package com.example.ejercicio_calculadoradeedad.controller;


import com.example.ejercicio_calculadoradeedad.model.Persona;
import com.example.ejercicio_calculadoradeedad.service.CalculadoraDeEdadService;
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

}
