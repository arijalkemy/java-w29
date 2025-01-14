package com.bootcamp.service;

import com.bootcamp.dto.response.IngredienteDto;

import java.util.List;

public interface IPlatoService {

    Double getCantidadTotalCaloriasPlato(String nombre);

    List<IngredienteDto> getListaIngredientesYCalorias(String nombre);

    IngredienteDto getIngredienteMayorCalorias(String nombre);
}
