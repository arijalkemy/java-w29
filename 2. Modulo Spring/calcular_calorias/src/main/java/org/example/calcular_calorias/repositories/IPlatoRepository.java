package org.example.calcular_calorias.repositories;

import org.example.calcular_calorias.entities.Platos;

import java.util.*;

public interface IPlatoRepository {
    List <Platos> obtenerPlatos();
    Platos buscarPlatoPorNombre(String nombre);
}
