package org.example.ej_edad_persona.Dtos;

import java.time.LocalDate;

public record FechaNacimientoDto(
        Integer dia,
        Integer mes,
        Integer anio
) {
    public LocalDate toLocalDate() {
        return LocalDate.of(anio, mes, dia);
    }

    public static LocalDate toLocalDate(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaActual = LocalDate.now();

        return LocalDate.of(anio, mes, dia);
    }
}
