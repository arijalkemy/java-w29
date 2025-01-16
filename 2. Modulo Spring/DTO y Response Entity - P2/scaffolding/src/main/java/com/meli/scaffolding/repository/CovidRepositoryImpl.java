package com.meli.scaffolding.repository;

import com.meli.scaffolding.entities.Persona;
import com.meli.scaffolding.entities.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CovidRepositoryImpl implements ICovidRepository {

    private List<Sintoma> sintomas = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public CovidRepositoryImpl() {
        sintomas.add(new Sintoma(1L, "Fiebre", 2));
        sintomas.add(new Sintoma(2L, "Tos", 1));
        sintomas.add(new Sintoma(3L, "Dolor de cabeza", 3));

        List<Sintoma> sintomasPersona1 = new ArrayList<>();
        sintomasPersona1.add(sintomas.get(0));
        sintomasPersona1.add(sintomas.get(1));

        List<Sintoma> sintomasPersona2 = new ArrayList<>();
        sintomasPersona2.add(sintomas.get(2));

        List<Sintoma> sintomasPersona3 = new ArrayList<>();
        sintomasPersona3.add(sintomas.get(0));
        sintomasPersona3.add(sintomas.get(2));

        List<Sintoma> sintomasPersona4 = new ArrayList<>();
        sintomasPersona4.add(sintomas.get(1));

        personas.add(new Persona(1L, "Juan", "Perez", 65, sintomasPersona1));
        personas.add(new Persona(2L, "Ana", "Gomez", 55, sintomasPersona2));
        personas.add(new Persona(3L, "Carlos", "Lopez", 70, sintomasPersona3));
        personas.add(new Persona(4L, "Maria", "Martinez", 60, sintomasPersona4));
    }

    @Override
    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    @Override
    public Integer nivelDeGravedad(String name) {
        Optional<Sintoma> s = getByName(name);
        return s.get().getNivel_de_gravedad();
    }

    @Override
    public Optional<Sintoma> getByName(String name) {
        return sintomas.stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public List<Persona> getPersonas() {
        return personas;
    }
}
