package com.bootcamp.CalculadoraCalorias.service;

import com.bootcamp.CalculadoraCalorias.dto.CaloriasPorPlatoDTO;
import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;

import java.util.List;

public interface PlatoService {

    CaloriasPorPlatoDTO calcularCaloriasPorPlatoYPeso(String nombre, Double peso);

    List<IngredienteDTO> obtenerIngredientes(String nombre);

    IngredienteDTO obtenerIngredienteConMasCalorias(String nombre);
}
