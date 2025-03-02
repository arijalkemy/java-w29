package com.calccal.calculadoracalorias.repository;

import com.calccal.calculadoracalorias.model.Ingrediente;
import com.calccal.calculadoracalorias.model.Plato;

import java.util.List;

public interface IPlatosRepository {
    List<Ingrediente> findAllIngr();
    List<Plato> findAllPlatos();
    Plato findPlatoByName(String nombrePlato);
}
