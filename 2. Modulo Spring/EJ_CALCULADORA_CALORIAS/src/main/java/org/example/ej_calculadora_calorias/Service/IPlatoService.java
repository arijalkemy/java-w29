package org.example.ej_calculadora_calorias.Service;

import org.example.ej_calculadora_calorias.Dto.IngredienteDTO;

import java.util.List;

public interface IPlatoService {

    Integer getCalorias(String name);

    List<IngredienteDTO> getIngredientes(String plato);

    IngredienteDTO maxCalorias(String plato);

}
