package org.example.calcular_calorias.services;

import org.example.calcular_calorias.dtos.CaloriasTotalesDto;
import org.example.calcular_calorias.dtos.IngredientesDto;
import org.example.calcular_calorias.dtos.PlatosDto;

import java.util.*;

public interface ICalcularCaloriasService {
    CaloriasTotalesDto calcularCalorias(PlatosDto platosDto);
    List<IngredientesDto> obtenerIngredientes(String nombrePlato);
    IngredientesDto obtenerIngredienteConMasCalorias(String nombrePlato);
}
