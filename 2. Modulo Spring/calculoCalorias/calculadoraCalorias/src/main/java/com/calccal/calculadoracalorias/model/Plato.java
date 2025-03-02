package com.calccal.calculadoracalorias.model;

import com.calccal.calculadoracalorias.dto.IngredienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Plato {
    private String name;private
    List<Ingrediente> ingredientes;
    //private int calories;
}