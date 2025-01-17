package com.calculadora.calorias.service;

import com.calculadora.calorias.model.Ingrediente;

import java.util.List;

public interface IIngredienteService {
    public List<Ingrediente> findAll();
    public Ingrediente getIngredienteByName(String name);
}
