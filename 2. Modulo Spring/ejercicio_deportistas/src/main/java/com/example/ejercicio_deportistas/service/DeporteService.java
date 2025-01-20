package com.example.ejercicio_deportistas.service;


import java.util.List;

import com.example.ejercicio_deportistas.exceptions.NotFoundException;
import com.example.ejercicio_deportistas.model.Deporte;
import com.example.ejercicio_deportistas.repository.DeporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeporteService implements IDeporteService {
    private final DeporteRepository repositorio;

    public List<Deporte> encontrarTodos() {
        List<Deporte> deportes = this.repositorio.encontrarTodos();
        if (deportes == null) {
            throw new NotFoundException("No se encontraron deportes");
        } else {
            return deportes;
        }
    }

    public Deporte encontrarPorNombre(String nombre) {
        Deporte deporte = this.repositorio.encontrarPorNombre(nombre);
        if (deporte == null) {
            throw new NotFoundException("No se encontró el deporte");
        } else {
            return deporte;
        }
    }
}
