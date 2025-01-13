package com.example.calorias.repository;

import com.example.calorias.model.Comida;

import java.util.List;
import java.util.Optional;

public interface CalculadoraRepository {

    List<Comida> getAll();

    Optional<Comida> getByName(String name);

}
