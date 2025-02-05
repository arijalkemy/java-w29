package com.org.meli.caloriecalculator.service;

import com.org.meli.caloriecalculator.dto.IngredienteDto;
import com.org.meli.caloriecalculator.dto.PlatoDto;

public interface IPlatoService {
    String caloriasTotalesPlatos(String nombrePlato,Integer cantidad);
    PlatoDto mostrarIngredientesdePlato(String nombrePlato);
    IngredienteDto buscarIngredienteConMasCalorias(String nombrePlato);
}
