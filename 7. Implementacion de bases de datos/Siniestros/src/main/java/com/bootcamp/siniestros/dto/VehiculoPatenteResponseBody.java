package com.bootcamp.siniestros.dto;

public record VehiculoPatenteResponseBody(
        String patente,
        String marca,
        Integer anio
) {
}
