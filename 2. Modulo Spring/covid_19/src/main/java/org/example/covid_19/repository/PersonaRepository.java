package org.example.covid_19.repository;

import org.example.covid_19.entity.Persona;
import org.example.covid_19.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {
    private List<Persona> personas;

    public PersonaRepository() {
        this.personas = new ArrayList<>();
        // Agrega algunas personas a la lista inicial
        personas.add(new Persona(1L, "Juan", "Pérez", 65, new ArrayList<>() {{
            add(new Sintoma(001, "Fiebre", "Alta"));
        }}));
        personas.add(new Persona(2L, "Ana", "García", 45, new ArrayList<>()));
    }

    public List<Persona> findAll() {
        return personas;
    }
}
