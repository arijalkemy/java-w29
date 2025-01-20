package com.example.ejercicio_deportistas.service;


import java.util.List;
import java.util.stream.Collectors;

import com.example.ejercicio_deportistas.dto.DeportistaDTO;
import com.example.ejercicio_deportistas.repository.DeportistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeportistaService implements IDeportistaService {
    private final DeportistaRepository repositorio;

    public DeportistaDTO encontrar(String nombre) {
        return DeportistaDTO.convertirDTO(repositorio.encontrarPorNombre(nombre));
    }

    public List<DeportistaDTO> encontrarTodo() {
        return repositorio.encontrarTodos()
                .stream()
                .map(DeportistaDTO::convertirDTO)
                .toList();
    }

    public List<DeportistaDTO> encontrarDeportistasPorDeporte(String deporte) {
        List<DeportistaDTO> deportistasDTO = this.encontrarTodo();
        return deportistasDTO
                .stream()
                .filter(d -> d.nombreDeporte().equalsIgnoreCase(deporte))
                .collect(Collectors.toList());
    }
}
