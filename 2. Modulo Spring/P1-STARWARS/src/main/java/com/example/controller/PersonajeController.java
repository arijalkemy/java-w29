package com.example.controller;

import com.example.dto.PersonajeDto;
import com.example.entities.Personaje;
import com.example.service.IPersonajeService;
import com.example.service.PersonajeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.List;


@RestController
public class PersonajeController {

    private IPersonajeService personajeService;

    public PersonajeController(IPersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDto>> listar() {
        return new ResponseEntity<>(personajeService.searchAllPersonajes(), HttpStatus.OK);
    }

    @GetMapping("/imprimir")
    public String imprimir() {
        return "Hola";
    }

}