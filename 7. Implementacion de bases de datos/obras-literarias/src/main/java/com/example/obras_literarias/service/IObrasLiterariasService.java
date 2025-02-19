package com.example.obras_literarias.service;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.example.obras_literarias.dto.ObraLiterariaResponseDto;

import java.util.List;

public interface IObrasLiterariasService {
    ObraLiterariaResponseDto createObraLiteraria(ObraLiterariaRequestDto request);
    List<ObraLiterariaResponseDto> searchAll();
    List<ObraLiterariaResponseDto> searchByAutor(String autor);
    List<ObraLiterariaResponseDto> searchByPalabarasClaveTitulo(String titulo);
    List<ObraLiterariaResponseDto> searchByCantidadDePaginas(Integer cantidadDePaginas);
    List<ObraLiterariaResponseDto> searchBeforeYear(Integer year);
    List<ObraLiterariaResponseDto> searchByEditorial(String editorial);
}
