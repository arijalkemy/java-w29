package com.example.demo.service;


import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;


@Service
public class EdadServiceImp implements EdadService {

    @Override
    public Integer calcularEdad(Integer d, Integer m, Integer a) {

        LocalDate hoy = LocalDate.now();
        LocalDate fechaNacimiento;

        try {
            // Construir la fecha de nacimiento
            fechaNacimiento = LocalDate.of(a, m, d);

            // Validar que la fecha no sea futura
            if (fechaNacimiento.isAfter(hoy)) {
                throw new IllegalArgumentException("La fecha de nacimiento no puede ser mayor que la fecha actual.");
            }

            // Calcular la edad
            return Period.between(fechaNacimiento, hoy).getYears();
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("La fecha proporcionada no es válida.");
        }
    }
}
