package com.example.demo.repository;

import com.example.demo.model.Deporte;
import java.util.List;

public interface IDeporteRepository {
    List<Deporte> encontrarTodos();

    Deporte encontrarPorNombre(String nombre);
}
