package com.deportistas.deportistas.services;

import org.springframework.stereotype.Service;

import com.deportistas.deportistas.dto.DeportistaDto;
import com.deportistas.deportistas.models.Deporte;
import com.deportistas.deportistas.models.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {
    private final List<Deporte> deportes = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();

    public DeporteService() {
        // Datos iniciales
        deportes.add(new Deporte("Fútbol", "Avanzado"));
        deportes.add(new Deporte("Natación", "Intermedio"));
        deportes.add(new Deporte("Tenis", "Principiante"));

        personas.add(new Persona("Juan", "Pérez", 25, deportes.get(0)));
        personas.add(new Persona("Ana", "Gómez", 30, deportes.get(1)));
        personas.add(new Persona("Luis", "Martínez", 22, deportes.get(2)));
    }

    public List<Deporte> getAllDeportes() {
        return deportes;
    }

    public Optional<Deporte> findDeporteByName(String nombre) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    public List<DeportistaDto> getAllDeportistas() {
        List<DeportistaDto> deportistas = new ArrayList<>();
        for (Persona persona : personas) {
            deportistas.add(new DeportistaDto(
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getDeporte().getNombre()));
        }
        return deportistas;
    }
}
