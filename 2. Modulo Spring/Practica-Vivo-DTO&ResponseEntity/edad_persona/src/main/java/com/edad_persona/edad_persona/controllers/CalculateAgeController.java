package com.edad_persona.edad_persona.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculateAgeController {

    @GetMapping("/{day}/{month}/{year}")
    public String getMethodName(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {

        LocalDate birthDate = LocalDate.of(year, month, day);

        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);

        Integer years = period.getYears();

        return "La edad de la persona es: " + years;
    }

}
