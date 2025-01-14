package org.example.ej_deportistas.Services;

import org.example.ej_deportistas.Models.Deporte;
import org.example.ej_deportistas.Models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements DeportesService {

    private final List<Deporte> deportes = new ArrayList<>(List.of(

            new Deporte("Fútbol", "Avanzado"),
            new Deporte("Baloncesto", "Intermedio"),
            new Deporte("Natación", "Principiante"),
            new Deporte("Tenis", "Avanzado"),
            new Deporte("Ciclismo", "Intermedio")
    ));

    @Override
    public List<Deporte> getAllDeportes() {
        return deportes;
    }

    @Override
    public Deporte getDeportebyName(String nombre) {
        return deportes.stream().filter(d -> d.getNombre()
                .equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }
}
