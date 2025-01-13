package com.meli.ej_deportistas.repository;

import com.meli.ej_deportistas.model.Deporte;

import java.util.List;
import java.util.Optional;

public interface DeporteRepository {
    List<Deporte> findAll();
    Optional<Deporte> findByNombre(String nombre);
}
