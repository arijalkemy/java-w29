package com.example.ejercicio_contadorcalorias.repository;


import com.example.ejercicio_contadorcalorias.dto.response.IngredienteDTO_Out;

public interface IIngredienteRepository {
    IngredienteDTO_Out getByName(String name);
}