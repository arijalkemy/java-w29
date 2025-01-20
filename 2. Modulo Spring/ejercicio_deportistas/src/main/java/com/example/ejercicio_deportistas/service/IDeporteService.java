package com.example.ejercicio_deportistas.service;


import com.example.ejercicio_deportistas.model.Deporte;

import java.util.List;

public interface IDeporteService {
    List<Deporte> encontrarTodos();
    Deporte encontrarPorNombre(String nombre);
}
