package org.example.ej_starwars.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ej_starwars.Entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {


    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        loadData();
    }

    private void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = TypeReference.class.getResourceAsStream("/starwars.json");
            personajes = mapper.readValue(is, new TypeReference<List<Personaje>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> getAll() {
        return personajes;
    }
}
