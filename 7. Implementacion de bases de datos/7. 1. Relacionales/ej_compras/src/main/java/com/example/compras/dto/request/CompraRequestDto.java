package com.example.compras.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CompraRequestDto(
        LocalDate fecha,
        @JsonProperty("monto_total")
        Double monto
) {
}
