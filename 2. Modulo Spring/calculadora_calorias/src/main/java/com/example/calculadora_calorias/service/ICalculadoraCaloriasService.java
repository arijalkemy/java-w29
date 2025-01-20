package com.example.calculadora_calorias.service;


import com.example.calculadora_calorias.dto.request.DishInfoRequestDTO;
import com.example.calculadora_calorias.dto.response.DishInfoResponseDTO;

import java.util.List;

public interface ICalculadoraCaloriasService {
    List<DishInfoResponseDTO> getDishesInfo(List<DishInfoRequestDTO> dishInfoRequest);
}