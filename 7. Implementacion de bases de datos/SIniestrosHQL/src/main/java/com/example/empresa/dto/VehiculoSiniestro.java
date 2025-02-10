package com.example.empresa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VehiculoSiniestro (
        VehiculoDto vehiculo,
        @JsonProperty("total_perdida_economica")
        Long totalPerdidaEconomica) {
}
