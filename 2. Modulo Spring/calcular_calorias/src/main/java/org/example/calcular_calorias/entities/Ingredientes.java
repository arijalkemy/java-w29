package org.example.calcular_calorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredientes {
    private String nombreIngrediente;
    private Double caloriasPorGramo;
}
