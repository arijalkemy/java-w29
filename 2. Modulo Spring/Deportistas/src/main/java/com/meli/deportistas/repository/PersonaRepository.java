package com.meli.deportistas.repository;

import com.meli.deportistas.model.PersonaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository {
    public List<PersonaModel> personas;

    public PersonaRepository() {
        personas = new ArrayList<PersonaModel>();
        personas.add(new PersonaModel("Pinilla", 12, "Edwin"));
        personas.add(new PersonaModel("Pinilla", 12, "Edwin"));
        personas.add(new PersonaModel("Pinilla", 12, "Edwin"));
        personas.add(new PersonaModel("Pinilla", 12, "Edwin"));
        personas.add(new PersonaModel("Pinilla", 12, "Edwin"));
        personas.add(new PersonaModel("Pinilla", 12, "Edwin"));
    }
}
