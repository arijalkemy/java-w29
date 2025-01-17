package com.ejercicio.covid.repository;

import com.ejercicio.covid.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonasRepository {
    private List<Persona> personas;

    public PersonasRepository(List<Persona> personas) {
        this.personas = personas;
    }

    public void add(Persona persona) {
        this.personas.add(persona);
    }

    public List<Persona> getPersonasMayoresConSintomas() {
        return this.personas.stream().filter(p -> !p.getSintomas().isEmpty() && p.getEdad()>60).collect(Collectors.toList());
    }
}
