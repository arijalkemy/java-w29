package com.example.deportistas.repository;

import com.example.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeporteRepository {

    List<Deporte> getAll();

    Optional<Deporte> findByNombre(String nombre);

}
