package com.org.meli.caloriecalculator.repository;

import com.org.meli.caloriecalculator.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    List<Ingrediente> obtenerIngredientes();
    Ingrediente buscarIngredienteConMasCalorias();

}
