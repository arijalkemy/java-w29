package com.example.demo.edad_persona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadPersona {
    @GetMapping("age/{day}/{month}/{year}")
    public int getEdadPersona(@PathVariable int day, @PathVariable int month, @PathVariable int year) {

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser posterior a la fecha actual.");
        }
        return today.compareTo(birthDate);
    }

}
