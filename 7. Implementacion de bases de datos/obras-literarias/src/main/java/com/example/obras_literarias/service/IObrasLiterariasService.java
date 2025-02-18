package com.example.obras_literarias.service;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.example.obras_literarias.dto.ObraLiterariaResponseDto;

import java.util.List;

public interface IObrasLiterariasService {
    ObraLiterariaResponseDto createObraLiteraria(ObraLiterariaRequestDto request);
    List<ObraLiterariaResponseDto> searchAll();

    // Retornar todas las obras de un autor
    List<ObraLiterariaResponseDto> getObrasByAutor(String autor);

    // Retornar obras que contienen una palabra clave en el título
    List<ObraLiterariaResponseDto> getObrasByTitulo(String keyword);

    // Retornar las top 5 obras con más cantidad de páginas
    List<ObraLiterariaResponseDto> getTop5ObrasPorPaginas();

    // Retornar obras publicadas antes de un determinado año
    List<ObraLiterariaResponseDto> getObrasAntesDelAno(int year);

    // Retornar todas las obras de una determinada editorial
    List<ObraLiterariaResponseDto> getObrasPorEditorial(String editorial);
}




