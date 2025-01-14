package com.bootcamp.CalculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredienteDTO {
    private String nombre;
    private Integer calorias;
}
