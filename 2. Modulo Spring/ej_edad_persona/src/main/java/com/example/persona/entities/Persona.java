package com.example.persona.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@Builder
public class Persona {
    private Long id;

    private LocalDate fechaNacimiento;

    public Integer calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
