package com.example.starwars.service;

import com.example.starwars.dto.response.PersonajeResponseDTO;
import com.example.starwars.repository.PersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements PersonajeService{
    private final PersonajeRepository _personajeRepository;

    @Override
    public List<PersonajeResponseDTO> obtenerCoincidenciaPorNombre(String cadena) {
        ObjectMapper om = new ObjectMapper();
        List<PersonajeResponseDTO> lista = _personajeRepository.obtenerCoincidenciaPorNombre(cadena).stream()
                .map(p -> om.convertValue(p, PersonajeResponseDTO.class))
                .collect(Collectors.toList());
        return lista;
    }
}
