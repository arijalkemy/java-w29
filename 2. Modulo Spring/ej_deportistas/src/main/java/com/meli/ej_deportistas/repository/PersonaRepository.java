package com.meli.ej_deportistas.repository;

import com.meli.ej_deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository {
    List<Persona> findAll();
    void save(Persona persona);
}
