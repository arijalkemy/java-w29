package com.bootcamp.CalculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaloriasPorPlatoDTO {
    private String nombreDelPlato;
    private Double calorias;
}
