package dev.calories.service;

import dev.calories.dto.IngredienteDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPlatoService {

    Double getCantidadTotalCaloriasPlato(String nombre);

    List<IngredienteDto> getListaIngredientesYCalorias(String nombre);

    IngredienteDto getIngredienteMayorCalorias(String nombre);

}
