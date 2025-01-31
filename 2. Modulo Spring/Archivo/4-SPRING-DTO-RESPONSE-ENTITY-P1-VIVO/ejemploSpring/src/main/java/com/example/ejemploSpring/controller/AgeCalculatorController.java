package com.example.ejemploSpring.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.Period;

    @RestController
    @RequestMapping()
    class AgeCalculatorController {

        @GetMapping("/{day}/{month}/{year}")
        public String calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
            try {
                LocalDate birthDate = LocalDate.of(year, month, day);
                LocalDate currentDate = LocalDate.now();

                if (birthDate.isAfter(currentDate)) {
                    return "Error: La fecha de nacimiento no puede ser en el futuro.";
                }

                int age = Period.between(birthDate, currentDate).getYears();
                return "La edad de la persona es: " + age + " años.";
            } catch (Exception e) {
                return "Error: Fecha no válida. Por favor verifica los valores ingresados.";
            }
        }
}
