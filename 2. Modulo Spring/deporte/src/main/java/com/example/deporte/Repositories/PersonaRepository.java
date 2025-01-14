package com.example.deporte.Repositories;
import com.example.deporte.Models.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository {
    List<Persona> findAll();
    void save(Persona persona);
}
