package com.bootcamp.CalculadoraCalorias.repository;

import com.bootcamp.CalculadoraCalorias.entity.Plato;

import java.util.Optional;

public interface PlatoRepository {

    Optional<Plato> devolverPlatoPorNombre(String nombre);
}
