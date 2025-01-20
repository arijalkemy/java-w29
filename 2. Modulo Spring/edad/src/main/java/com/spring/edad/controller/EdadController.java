package com.spring.edad.controller;

import com.spring.edad.service.EdadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RequestMapping("/edad")
@RestController
public class EdadController {

    private final EdadService edadService;

    public EdadController(EdadService edadService) {
        this.edadService = edadService;
    }


    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity edad(@PathVariable Integer day,
                        @PathVariable Integer month,
                        @PathVariable Integer year) {

        Integer edad = edadService.calcularEdad(day,month,year);
       if (edad != null) {
           return ResponseEntity.ok(edad);
       } else {
           return ResponseEntity.notFound().build();
       }

    }
}
