package org.example.arquitectura_multicapa_1_vivo.service;

import lombok.AllArgsConstructor;
import org.example.arquitectura_multicapa_1_vivo.dto.response.PersonajeResponseDTO;
import org.example.arquitectura_multicapa_1_vivo.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeResponseDTO> buscarPorNombre(String nombre) {

        try {
            return personajeRepository.buscarPorNombre(nombre).stream()
                    .map(p ->
                            new PersonajeResponseDTO(p.getName(),
                                    p.getHeight(),
                                    p.getMass(),
                                    p.getGender(),
                                    p.getHomeworld(),
                                    p.getSpecies()))
                            .collect(Collectors.toList());

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
