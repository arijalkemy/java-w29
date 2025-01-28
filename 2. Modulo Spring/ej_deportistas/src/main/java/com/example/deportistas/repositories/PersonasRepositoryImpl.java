package com.example.deportistas.repositories;

import com.example.deportistas.enums.Nivel;
import com.example.deportistas.models.Deporte;
import com.example.deportistas.models.Persona;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonasRepositoryImpl implements PersonasRepository {

    private final DeportesRepository deportesRepository;

    private final List<Persona> personas = new ArrayList<>(List.of(
            new Persona("Juan", "Pérez", 25, new Deporte("Fútbol", Nivel.AVANZADO)),
            new Persona("Ana", "González", 22, new Deporte("Baloncesto", Nivel.INTERMEDIO)),
            new Persona("Carlos", "Rodríguez", 30, new Deporte("Natación", Nivel.PRINCIPIANTE)),
            new Persona("Laura", "Martínez", 28, new Deporte("Tenis", Nivel.AVANZADO)),
            new Persona("Pedro", "Sánchez", 24, new Deporte("Ciclismo", Nivel.INTERMEDIO))
    ));;

    @PostConstruct
    public void init() {
        personas.forEach(p -> p.setDeporte(deportesRepository.findRandomSport()));
    }

    @Override
    public List<Persona> findAll() {
        return personas;
    }
}
