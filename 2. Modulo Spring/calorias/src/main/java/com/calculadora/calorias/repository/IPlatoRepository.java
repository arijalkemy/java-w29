package com.calculadora.calorias.repository;

import com.calculadora.calorias.model.Plato;

import java.util.List;
import java.util.Optional;

public interface IPlatoRepository {
    public List<Plato> getPlatos();
    public Optional<Plato> getPlato(String plato);
}
