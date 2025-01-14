package org.example.ej_deportistas.Services;

import org.example.ej_deportistas.Dtos.DeportistaDto;
import org.example.ej_deportistas.Models.Deporte;
import org.example.ej_deportistas.Models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {


    private final List<Persona> personas;

    public PersonaServiceImpl() {
        this.personas = new ArrayList<>(List.of(
                new Persona("Juan", "Feo", 22, new Deporte("Fútbol", "Avanzado")),
                new Persona("Steven", "Ortiz", 25, new Deporte("Basketball", "Intermedio")),
                new Persona("Meliza", "Leon", 30, new Deporte("Natación", "Principiante")),
                new Persona("Andrea", "Ortiz", 28, new Deporte("Voleyball", "Avanzado")),
                new Persona("Sofia", "Rojas", 24, new Deporte("Ciclismo", "Intermedio"))
        ));
    }

    @Override
    public List<DeportistaDto> getAllPersonas() {
        return personas.stream().map(DeportistaDto::toDto).toList();
    }
}
