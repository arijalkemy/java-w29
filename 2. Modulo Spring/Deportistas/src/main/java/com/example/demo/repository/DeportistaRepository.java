//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.repository;

import com.example.demo.model.Deporte;
import com.example.demo.model.Deportista;
import java.util.ArrayList;
import java.util.List;
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
