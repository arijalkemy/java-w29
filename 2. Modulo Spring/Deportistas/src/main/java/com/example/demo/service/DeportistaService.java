//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service;

import com.example.demo.dto.DeportistaDTO;
import com.example.demo.repository.DeportistaRepository;
import java.util.List;
import java.util.stream.Collectors;
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
