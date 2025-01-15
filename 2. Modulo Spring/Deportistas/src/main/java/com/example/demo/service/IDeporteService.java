package com.example.demo.service;

import com.example.demo.model.Deporte;
import java.util.List;

public interface IDeporteService {
    List<Deporte> encontrarTodos();
    Deporte encontrarPorNombre(String nombre);
}
