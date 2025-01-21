package org.example.ejerciciocovid.Repositories;

import org.example.ejerciciocovid.Entities.Persona;
import org.example.ejerciciocovid.Entities.Sintoma;
import org.example.ejerciciocovid.Enums.NivelGravedad;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {


    List<Persona> personas = new ArrayList<>(List.of(
            new Persona(1, "Juan", "Pérez", 65, List.of(
                    new Sintoma(1, "Fiebre", NivelGravedad.ALTO),
                    new Sintoma(4, "Fatiga", NivelGravedad.MEDIO))),
            new Persona(2, "Ana", "González", 45, List.of(
                    new Sintoma(3, "Dolor de cabeza", NivelGravedad.BAJO))),
            new Persona(3, "Carlos", "Rodríguez", 75, List.of(
                    new Sintoma(5, "Dificultad para respirar", NivelGravedad.ALTO))),
            new Persona(4, "Laura", "Martínez", 30, new ArrayList<>()),
            new Persona(5, "Pedro", "Sánchez", 58, List.of(
                    new Sintoma(2, "Tos", NivelGravedad.BAJO)))
    ));

    @Override
    public List<Persona> getAll() {
        return personas;
    }
}
