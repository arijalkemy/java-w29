package com.example.deportistas.repository;

import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository {

    List<Persona> getAll();

}
