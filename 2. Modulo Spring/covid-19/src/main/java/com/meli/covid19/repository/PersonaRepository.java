package com.meli.covid19.repository;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.model.PersonaModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonaRepository {
    public List<PersonaModel> GetAllPersonas() {
        List<PersonaModel> personas = new ArrayList<>();
        personas.add(new PersonaModel("Suarez", 16, 11234, "Luis", Arrays.asList(1, 2)));
        personas.add(new PersonaModel("Hamilton", 45, 11234, "Lewis", Arrays.asList(3, 8)));
        personas.add(new PersonaModel("Bagnaia", 64, 11234, "Frederick", Arrays.asList()));
        personas.add(new PersonaModel("Messi", 77, 11234, "Leonel", Arrays.asList(9, 6)));
        personas.add(new PersonaModel("Do Santos", 69, 11234, "Cristiano", Arrays.asList(7, 5)));
        personas.add(new PersonaModel("Carbonó", 21, 11234, "Michell", Arrays.asList()));
        return personas;
    }
}
