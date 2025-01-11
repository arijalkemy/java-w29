package com.example.persona.services;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;

@Service
public class PersonaService {

    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento;

        // Validar que sea una fecha válida
        try {
            fechaNacimiento = LocalDate.of(anio, mes, dia);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Fecha de nacimiento no válida: " + e.getMessage());
        }

        // Validar que sea una fecha anterior a la fecha actual
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser anterior a la fecha actual");
        }

        // Calcular edad
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaActual.getDayOfYear() < fechaNacimiento.getDayOfYear()) {
            edad--;
        }

        return edad;
    }

}
