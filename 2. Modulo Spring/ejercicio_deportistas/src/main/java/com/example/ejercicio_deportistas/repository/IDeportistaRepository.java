package com.example.ejercicio_deportistas.repository;
import com.example.ejercicio_deportistas.model.Deportista;

import java.util.List;

public interface IDeportistaRepository {
    Deportista encontrarPorNombre(String nombre);

    List<Deportista> encontrarTodos();
}
