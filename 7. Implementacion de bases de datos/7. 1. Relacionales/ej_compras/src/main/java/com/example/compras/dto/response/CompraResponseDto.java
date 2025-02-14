package com.example.compras.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CompraResponseDto(
    @JsonProperty("cliente")
    ClienteResponseDto clienteDto,
    LocalDate fecha,
    @JsonProperty("monto_total")
    Double montoTotal
) {}
