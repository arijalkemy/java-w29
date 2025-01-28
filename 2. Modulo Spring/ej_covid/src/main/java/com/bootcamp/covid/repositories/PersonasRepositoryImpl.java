package com.bootcamp.covid.repositories;

import com.bootcamp.covid.entities.Persona;
import com.bootcamp.covid.entities.Sintoma;
import com.bootcamp.covid.enums.NivelDeGravedad;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonasRepositoryImpl implements PersonasRepository {

    List<Persona> personas = new ArrayList<>(List.of(
            new Persona(1, "Juan", "Pérez", 65, List.of(
                    new Sintoma(1, "Fiebre", NivelDeGravedad.ALTO),
                    new Sintoma(4, "Fatiga", NivelDeGravedad.MEDIO))),
            new Persona(2, "Ana", "González", 45, List.of(
                    new Sintoma(3, "Dolor de cabeza", NivelDeGravedad.BAJO))),
            new Persona(3, "Carlos", "Rodríguez", 75, List.of(
                    new Sintoma(5, "Dificultad para respirar", NivelDeGravedad.ALTO))),
            new Persona(4, "Laura", "Martínez", 30, new ArrayList<>()),
            new Persona(5, "Pedro", "Sánchez", 58, List.of(
                    new Sintoma(2, "Tos", NivelDeGravedad.BAJO)))
            ));

    @Override
    public List<Persona> findAll() {
        return personas;
    }
}
