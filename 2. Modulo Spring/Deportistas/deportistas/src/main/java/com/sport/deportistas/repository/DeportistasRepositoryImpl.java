package com.sport.deportistas.repository;

import com.sport.deportistas.entity.Deporte;
import com.sport.deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistasRepositoryImpl implements IDeportistasRepository {

    List<Persona> personas = new ArrayList<>(List.of(
            new Persona("Pepa", "López", 35),
            new Persona("Pepe", "Pérez", 35),
            new Persona("Pepi", "Fernández", 35),
            new Persona("Ana", "González", 28),
            new Persona("Luis", "Martínez", 40),
            new Persona("Carlos", "Ramírez", 32),
            new Persona("Marta", "Sánchez", 25),
            new Persona("José", "García", 38),
            new Persona("Isabel", "Torres", 30),
            new Persona("Juan", "Hernández", 33),
            new Persona("Carmen", "Vázquez", 29),
            new Persona("Raúl", "Serrano", 36),
            new Persona("Laura", "Jiménez", 27),
            new Persona("David", "Muñoz", 34)
    ));

    List<Deporte> deportes = new ArrayList<>(List.of(
            new Deporte("Patín", 5),
            new Deporte("Handball", 3),
            new Deporte("Basket", 1),
            new Deporte("Gimnasia", 5),
            new Deporte("Fútbol", 2),
            new Deporte("Volley", 4)));

    @Override
    public List<Persona> searchPersonas() {
        return personas;
    }

    @Override
    public List<Deporte> searchDeportes() {
        return deportes;
    }

    @Override
    public Deporte searchDeporteByName(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
