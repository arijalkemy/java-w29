package org.example.calcular_calorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.calcular_calorias.entities.Ingredientes;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaloriasTotalesDto {
    private Double totalCalorias;
    private List<IngredientesDto> ingredientes;
}
