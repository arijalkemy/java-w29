package org.example.arquitectura_multicapa_1_vivo.controller;

import lombok.AllArgsConstructor;
import org.example.arquitectura_multicapa_1_vivo.dto.response.PersonajeResponseDTO;
import org.example.arquitectura_multicapa_1_vivo.service.PersonajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController("/personaje")
public class PersonajeController {

    private final PersonajeService personajeService;

    @GetMapping("/buscarPorNombre")
    public List<PersonajeResponseDTO> buscarPorNombre(String nombre) {
        return personajeService.buscarPorNombre(nombre);
    }

}
