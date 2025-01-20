package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.DeportistaDTO;

import java.util.List;

public interface IDeportistaService {
    DeportistaDTO encontrar(String nombre);
    List<DeportistaDTO> encontrarDeportistasPorDeporte(String nombre);
}
