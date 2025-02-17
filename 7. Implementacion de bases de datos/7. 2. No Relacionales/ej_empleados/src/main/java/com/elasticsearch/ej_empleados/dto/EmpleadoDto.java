package com.elasticsearch.ej_empleados.dto;

public record EmpleadoDto(
        String id,
        String nombre,
        String apellido,
        Integer edad,
        String ciudad,
        String provincia) {
}
