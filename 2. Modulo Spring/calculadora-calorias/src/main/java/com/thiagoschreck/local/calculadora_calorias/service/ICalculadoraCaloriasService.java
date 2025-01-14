package com.thiagoschreck.local.calculadora_calorias.service;

import com.thiagoschreck.local.calculadora_calorias.dto.request.DishInfoRequestDTO;
import com.thiagoschreck.local.calculadora_calorias.dto.response.DishInfoResponseDTO;

import java.util.List;

public interface ICalculadoraCaloriasService {
    List<DishInfoResponseDTO> getDishesInfo(List<DishInfoRequestDTO> dishInfoRequest);
}
