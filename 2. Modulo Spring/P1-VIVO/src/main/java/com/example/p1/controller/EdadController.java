package com.example.p1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
@RestController
public class EdadController {
    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public Integer edad(@PathVariable Integer dia,
                        @PathVariable Integer mes ,@PathVariable Integer anio){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears();
    }
}
