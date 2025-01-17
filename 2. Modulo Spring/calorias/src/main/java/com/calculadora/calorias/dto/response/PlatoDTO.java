package com.calculadora.calorias.dto.response;

import com.calculadora.calorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private Double totalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMasCalorico;
}
