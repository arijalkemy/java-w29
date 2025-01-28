package org.example.calcular_calorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesDto {
    private String nombre;
    private Double calorias;
}
