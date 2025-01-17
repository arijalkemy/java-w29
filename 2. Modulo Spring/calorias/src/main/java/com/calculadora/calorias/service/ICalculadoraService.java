package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.response.PlatoDTO;

public interface ICalculadoraService {
    public PlatoDTO calcularCalorias(String name, Double peso);
}
