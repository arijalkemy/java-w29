package com.example.ejercicio_deportistas.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.ejercicio_deportistas.model.Deporte;
import com.example.ejercicio_deportistas.model.Deportista;
import org.springframework.stereotype.Repository;

@Repository
public class DeportistaRepository implements IDeportistaRepository {
    List<Deportista> deportistas;

    public DeportistaRepository() {
        deportistas = new ArrayList();

        deportistas.add(new Deportista("Juan", "Pérez", 25, new Deporte("Fútbol", 1)));
        deportistas.add(new Deportista("Ana", "González", 22, new Deporte("Baloncesto", 2)));
        deportistas.add(new Deportista("Carlos", "Sánchez", 28, new Deporte("Tenis", 3)));
        deportistas.add(new Deportista("María", "López", 30, new Deporte("Natación", 4)));
    }

    public Deportista encontrarPorNombre(String nombre) {
        return deportistas.stream()
                .filter((d) -> d.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Deportista> encontrarTodos() {
        return deportistas;
    }
}
