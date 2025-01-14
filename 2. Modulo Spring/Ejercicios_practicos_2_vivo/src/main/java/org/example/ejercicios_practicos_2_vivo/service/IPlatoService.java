package org.example.ejercicios_practicos_2_vivo.service;

import org.example.ejercicios_practicos_2_vivo.dto.PlatoResponseDto;

import java.util.List;

public interface IPlatoService {
    public PlatoResponseDto getplato(String nombre);

    public List<PlatoResponseDto> getAllplatos(List<String> platos);
}
