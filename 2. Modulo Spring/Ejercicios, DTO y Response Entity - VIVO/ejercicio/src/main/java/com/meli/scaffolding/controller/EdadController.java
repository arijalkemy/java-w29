package com.meli.scaffolding.controller;

import com.meli.scaffolding.entity.Persona;
import com.meli.scaffolding.service.IEdadCalculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {
    @Autowired
    IEdadCalculadora calculadora;
    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        return ResponseEntity.ok("La edad es: " + calculadora.calcularEdad(fechaNacimiento));
    }
    @PostMapping("/guardarPersona")
    public ResponseEntity<?> crearPesona(@RequestBody Persona persona) {
        calculadora.guardarPersona(persona);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> calcularEdadPersona(@PathVariable String id) {
        Persona p = calculadora.buscarPersona(id);
        if (p== null){
            return ResponseEntity.notFound().build();
        }
        Integer edad = Period.between(p.getFechaNacimiento(), LocalDate.now()).getYears();
        return ResponseEntity.ok("La edad de la persona: "+ p.getId() +" es: "+ edad);
    }

}
