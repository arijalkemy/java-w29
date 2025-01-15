package com.example.demo.controller;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.service.PersonajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class Controller {
    private final PersonajeService personajeService;

    public Controller(PersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping("/")
    public List<PersonajeDTO> obtenerPersonajesPorValor(@RequestParam String valor){
        return personajeService.obtenerPersonajes(valor);
    }
}
