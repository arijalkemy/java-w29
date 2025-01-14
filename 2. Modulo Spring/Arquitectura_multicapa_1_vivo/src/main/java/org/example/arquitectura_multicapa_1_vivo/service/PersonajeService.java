package org.example.arquitectura_multicapa_1_vivo.service;

import org.example.arquitectura_multicapa_1_vivo.dto.response.PersonajeResponseDTO;

import java.util.List;

public interface PersonajeService {
    List<PersonajeResponseDTO> buscarPorNombre(String nombre);
}
