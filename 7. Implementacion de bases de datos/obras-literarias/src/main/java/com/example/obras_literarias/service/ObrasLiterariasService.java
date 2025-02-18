package com.example.obras_literarias.service;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.example.obras_literarias.dto.ObraLiterariaResponseDto;
import com.example.obras_literarias.entity.ObraLiteraria;
import com.example.obras_literarias.repository.ObraLiterariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObrasLiterariasService implements IObrasLiterariasService {

    private final ObraLiterariaRepository repository;

    @Autowired
    public ObrasLiterariasService(ObraLiterariaRepository repository) {
        this.repository = repository;
    }

    // Método para crear una nueva obra literaria
    @Override
    public ObraLiterariaResponseDto createObraLiteraria(ObraLiterariaRequestDto request) {

        ObraLiteraria obraLiteraria = new ObraLiteraria(request);

        ObraLiteraria response = repository.save(obraLiteraria);

        return new ObraLiterariaResponseDto(response);
    }

    // Método para obtener todas las obras literarias
    @Override
    public List<ObraLiterariaResponseDto> searchAll() {

        List<ObraLiteraria> obras = (List<ObraLiteraria>) repository.findAll();


        return obras.stream()
                .map(ObraLiterariaResponseDto::new)
                .collect(Collectors.toList());
    }

    // Método para obtener obras por autor
    @Override
    public List<ObraLiterariaResponseDto> getObrasByAutor(String autor) {
        List<ObraLiteraria> obras = repository.findByAutor(autor);
        return obras.stream()
                .map(ObraLiterariaResponseDto::new)
                .collect(Collectors.toList());
    }

    // Método para obtener obras por título (palabra clave)
    @Override
    public List<ObraLiterariaResponseDto> getObrasByTitulo(String keyword) {
        List<ObraLiteraria> obras = repository.findByNombreContaining(keyword);
        return obras.stream()
                .map(ObraLiterariaResponseDto::new)
                .collect(Collectors.toList());
    }

    // Método para obtener las 5 obras con más páginas
    @Override
    public List<ObraLiterariaResponseDto> getTop5ObrasPorPaginas() {
        List<ObraLiteraria> obras = repository.findTop5ByOrderByCantidadDePaginasDesc();
        return obras.stream()
                .map(ObraLiterariaResponseDto::new)
                .collect(Collectors.toList());
    }

    // Método para obtener obras antes de un año específico
    @Override
    public List<ObraLiterariaResponseDto> getObrasAntesDelAno(int year) {
        List<ObraLiteraria> obras = repository.findByYearLessThan(year);
        return obras.stream()
                .map(ObraLiterariaResponseDto::new)
                .collect(Collectors.toList());
    }

    // Método para obtener obras por editorial
    @Override
    public List<ObraLiterariaResponseDto> getObrasPorEditorial(String editorial) {
        List<ObraLiteraria> obras = repository.findByEditorial(editorial);
        return obras.stream()
                .map(ObraLiterariaResponseDto::new)
                .collect(Collectors.toList());
    }
}
