package com.example.contador_calorias.services;

import com.example.contador_calorias.dto.request.PlatoDTO_In;
import com.example.contador_calorias.dto.response.PlatoDTO_Out;

import java.util.List;

public interface IPlatoService {
    PlatoDTO_Out calcularCalorias(PlatoDTO_In plato);
    List<PlatoDTO_Out> calcularCaloriasListado(List<PlatoDTO_In> plato);
}
