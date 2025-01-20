package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.model.Deporte;

import java.util.List;

public interface IDeporteRepository {
    List<Deporte> encontrarTodos();

    Deporte encontrarPorNombre(String nombre);
}