package com.org.meli.caloriecalculator.repository;

import com.org.meli.caloriecalculator.entity.Ingrediente;
import com.org.meli.caloriecalculator.entity.Plato;

public interface IPlatoRepository {
    Plato buscarPlatoPorNombre(String nombrePlato);
    Ingrediente buscarIngredienteConMasCalorias(String nombrePlato);
}
