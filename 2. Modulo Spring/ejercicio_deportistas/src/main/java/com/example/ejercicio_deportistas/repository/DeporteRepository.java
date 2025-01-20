package com.example.ejercicio_deportistas.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.ejercicio_deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

@Repository
public class DeporteRepository implements IDeporteRepository {
    List<Deporte> deportes;

    public DeporteRepository() {
        deportes = new ArrayList<>();

        deportes.add(new Deporte("Fútbol", 1));
        deportes.add(new Deporte("Baloncesto", 2));
        deportes.add(new Deporte("Tenis", 3));
        deportes.add(new Deporte("Natación", 4));
    }

    public List<Deporte> encontrarTodos() {
        return deportes;
    }

    public Deporte encontrarPorNombre(String nombre) {
        return deportes.stream()
                .filter((d) -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
