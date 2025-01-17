package com.calculadora.calorias.repository;

import com.calculadora.calorias.model.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    public List<Ingrediente> findAll();
    public Ingrediente getIngredienteByName(String name);
}
