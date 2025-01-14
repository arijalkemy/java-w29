package com.example.contador_calorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO_Out {
    private String plato;
    private Double peso;
    private Integer totalCalorias;
    private List<IngredienteDTO_Out> ingredientes;
    private String ingredienteCalorico;
}
