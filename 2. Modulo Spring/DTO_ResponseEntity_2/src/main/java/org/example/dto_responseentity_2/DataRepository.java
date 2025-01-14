package org.example.dto_responseentity_2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepository {
    private List<Persona> personas = new ArrayList<>();
    private List<Sintoma> sintomas = new ArrayList<>();


    // Métodos para obtener listas
    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    // Métodos para agregar datos
    public void addPersona(Persona persona) {
        personas.add(persona);
    }

    public void addSintoma(Sintoma sintoma) {
        sintomas.add(sintoma);
    }
}
