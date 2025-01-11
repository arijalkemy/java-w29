package com.example.__persona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    // parte 1
    @GetMapping("/{dia}/{mes}/{agno}")
    public Integer devolverEdad(@PathVariable Integer dia,
                                @PathVariable Integer mes,
                                @PathVariable Integer agno){
        LocalDate fechaNacimiento = LocalDate.of(agno, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaNacimiento, fechaActual);

        return period.getYears();
    }
}
