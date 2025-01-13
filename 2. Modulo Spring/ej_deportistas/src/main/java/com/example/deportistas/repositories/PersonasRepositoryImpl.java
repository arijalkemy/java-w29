package com.example.deportistas.repositories;

import com.example.deportistas.models.Deporte;
import com.example.deportistas.models.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasRepositoryImpl implements PersonasRepository {

    private final List<Persona> personas = new ArrayList<>(List.of(
            new Persona("Juan", "Pérez", 25, new Deporte("Fútbol", "Avanzado")),
            new Persona("Ana", "González", 22, new Deporte("Baloncesto", "Intermedio")),
            new Persona("Carlos", "Rodríguez", 30, new Deporte("Natación", "Principiante")),
            new Persona("Laura", "Martínez", 28, new Deporte("Tenis", "Avanzado")),
            new Persona("Pedro", "Sánchez", 24, new Deporte("Ciclismo", "Intermedio"))
    ));;

    @Override
    public List<Persona> getAll() {
        return personas;
    }

}
