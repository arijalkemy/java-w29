package com.example.empresa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VehiculoDto(
        Integer id,
        String marca,
        String modelo,
        String patente,
        Integer anio,
        @JsonProperty("cantidad_ruedas")
        Integer cantidadRuedas) {
}
