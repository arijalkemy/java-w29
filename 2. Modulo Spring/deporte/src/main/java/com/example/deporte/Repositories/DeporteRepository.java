package com.example.deporte.Repositories;

import com.example.deporte.Models.Deporte;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeporteRepository {
    List<Deporte> findAll();
    Optional<Deporte> findByNombre(String nombre);
}
