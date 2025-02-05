package com.org.meli.caloriecalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class IngredienteDto {
    String nombre;
    Integer calorias;
}
