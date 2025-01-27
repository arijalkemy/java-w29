package com.example.persona.dtos;

import java.time.DateTimeException;
import java.time.LocalDate;

public record FechaNacimientoDto (
        Integer dia,
        Integer mes,
        Integer anio
) {
    public LocalDate toLocalDate() {
        return LocalDate.of(anio, mes, dia);
    }

    public static LocalDate toLocalDate(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        // Validar que sea una fecha anterior a la fecha actual
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new DateTimeException("La fecha de nacimiento debe ser anterior a la fecha actual");
        }

        return fechaNacimiento;
    }
}
