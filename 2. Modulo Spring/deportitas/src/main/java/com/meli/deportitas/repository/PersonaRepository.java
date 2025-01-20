package com.meli.deportitas.repository;

import com.meli.deportitas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {

    private List<Persona> personas = new ArrayList<>() ;

    public PersonaRepository() {
        personas.add(new Persona("David","Cruz",22));
        personas.add(new Persona("Jose","Melo",23));
        personas.add(new Persona("Alejandra","Hernandez",24));
    }

    public List<Persona> getPersonas() {
        return personas;
    }


}
