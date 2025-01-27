package com.bootcamp.excercise.repository;

import com.bootcamp.excercise.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository{
    private List<Persona> personas = new ArrayList<>();
    private List<Persona> personasDeRiesgo = new ArrayList<>();

    public PersonaRepositoryImpl() {
        personas.add(new Persona(119352554,"David","Narvaez",24));
        personas.add(new Persona(101002914,"Juan","Garcia",23));
        personas.add(new Persona(100769859,"Gabriela","Rodriguez",24));
        personas.add(new Persona(516136523,"Alcira","Lossa",63));
        personas.add(new Persona(791036989,"Carlos","Sanchez",61));
    }

    @Override
    public List<Persona> findAllPersons() {
        return personas;
    }

    @Override
    public List<Persona> findPersonsWithSymptoms() {
        for(Persona p : personas){
            if(p.getEdad() > 60){
                personasDeRiesgo.add(p);
            }
        }
        return personasDeRiesgo;
    }
}
