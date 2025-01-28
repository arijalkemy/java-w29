package org.example.calcular_calorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriasTotalesPorPlatoDto {
    private String nombrePlato;
    private Double totalCalorias;
    private List<IngredientesDto> ingredientes;
}
