package com.example.starwars.service;

import com.example.starwars.dto.response.PersonajeResponseDTO;

import java.util.List;

public interface PersonajeService {
    public List<PersonajeResponseDTO> obtenerCoincidenciaPorNombre(String cadena);
}
