package com.example.deportistas.repositories;

import com.example.deportistas.models.Deporte;

import java.util.List;
import java.util.Optional;

public interface DeportesRepository {
    List<Deporte> findAll();

    Optional<Deporte> findByNombre(String nombre);

    Deporte findRandomSport();
}
