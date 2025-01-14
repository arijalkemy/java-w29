package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;

import java.util.List;

public interface PersonajeRepository {
    public List<Personaje> obtenerCoincidenciaPorNombre(String cadena);
}
