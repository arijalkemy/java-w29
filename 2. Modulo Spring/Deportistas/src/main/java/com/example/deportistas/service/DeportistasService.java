package com.example.deportistas.service;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService {
    private static final List<Deporte> deportes = List.of(
            Deporte.builder().nombre("Futbol").nivel("Amateur").build(),
            Deporte.builder().nombre("Basketball").nivel("Intermedio").build(),
            Deporte.builder().nombre("Baseball").nivel("Avanzado").build()
    );

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public Deporte buscarDeporte(String nombre) {
        return deportes.stream().filter(deporte -> deporte.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    private static final List<Persona> personas = List.of(Persona.builder().nombre("Juan").apellido("Perez").edad(25).build(),
            Persona.builder().nombre("Mario").apellido("Lopez").edad(25).deporte(Deporte.builder().nombre("Futbol").nivel("Amateur").build()).build(),
            Persona.builder().nombre("Paulina").apellido("Herrera").edad(29).deporte(Deporte.builder().nombre("Baseball").nivel("Amateur").build()).build(),
            Persona.builder().nombre("Erik").apellido("Calvillo").edad(25).build()
            );

    public List<Persona> buscarPersonasDeportista() {
        return personas.stream()
                .filter(persona -> persona.getDeporte() != null)
                .collect(Collectors.toList());
    }

}
