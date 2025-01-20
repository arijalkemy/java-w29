package com.example.ejercicio_contadorcalorias.service;

import com.example.ejercicio_contadorcalorias.dto.request.PlatoDTO_In;
import com.example.ejercicio_contadorcalorias.dto.response.PlatoDTO_Out;

import java.util.List;

public interface IPlatoService {
    PlatoDTO_Out calcularCalorias(PlatoDTO_In plato);
    List<PlatoDTO_Out> calcularCaloriasListado(List<PlatoDTO_In> plato);
}
