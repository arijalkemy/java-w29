package com.example.demo.service;

import com.example.demo.dto.DeportistaDTO;
import java.util.List;

public interface IDeportistaService {
    DeportistaDTO encontrar(String nombre);
    List<DeportistaDTO> encontrarDeportistasPorDeporte(String nombre);
}
