package com.calculadora.calorias.service;

import com.calculadora.calorias.model.Plato;

import java.util.List;
import java.util.Optional;

public interface IPlatoService {
    public List<Plato> findAll();
    public Optional<Plato> findPlatoByName(String name);
}
