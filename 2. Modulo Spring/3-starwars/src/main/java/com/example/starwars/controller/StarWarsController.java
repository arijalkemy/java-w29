package com.example.starwars.controller;

import com.example.starwars.dto.response.PersonajeResponseDTO;
import com.example.starwars.service.PersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
@RequiredArgsConstructor
public class StarWarsController {
    private final PersonajeService _personajeService;

    @GetMapping("/buscar/{cadena}")
    public ResponseEntity<List<PersonajeResponseDTO>> obtenerCoincidenciaPorNombre(@PathVariable String cadena){
        List<PersonajeResponseDTO> personajes = this._personajeService.obtenerCoincidenciaPorNombre(cadena);
        return new ResponseEntity<>(personajes,HttpStatus.OK);
    }
}
