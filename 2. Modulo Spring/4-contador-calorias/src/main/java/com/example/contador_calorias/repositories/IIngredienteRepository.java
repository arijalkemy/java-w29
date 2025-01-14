package com.example.contador_calorias.repositories;

import com.example.contador_calorias.dto.response.IngredienteDTO_Out;

public interface IIngredienteRepository {
    IngredienteDTO_Out getByName(String name);
}
