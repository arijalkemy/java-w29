package com.example.covid.repositories;

import com.example.covid.entity.Persona;
import com.example.covid.entity.Sintoma;
import com.example.covid.enums.NivelGravedadEnum;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {
    private List<Persona> personas;

    public PersonaRepositoryImpl(){
        this.cargarDatos();
    }

    public void cargarDatos(){
        this.personas = new ArrayList<>(List.of(
                new Persona(1L, "Juan", "Pérez", 65, List.of(
                        new Sintoma(1L, "Fiebre", NivelGravedadEnum.ALTO),
                        new Sintoma(4L, "Fatiga", NivelGravedadEnum.MEDIO))),
                new Persona(2L, "Ana", "González", 45, List.of(
                        new Sintoma(3L, "Dolor de cabeza", NivelGravedadEnum.BAJO))),
                new Persona(3L, "Carlos", "Rodríguez", 75, List.of(
                        new Sintoma(5L, "Dificultad para respirar", NivelGravedadEnum.ALTO))),
                new Persona(4L, "Laura", "Martínez", 30, new ArrayList<>()),
                new Persona(5L, "Pedro", "Sánchez", 58, List.of(
                        new Sintoma(2L, "Tos", NivelGravedadEnum.BAJO)))
        ));
    }

    @Override
    public List<Persona> findRiskPerson() {
        return this.personas.stream()
                .filter(p -> p.getEdad()>=60)
                .toList();
    }
}
