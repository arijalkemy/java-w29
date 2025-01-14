package com.example.demo.controller;
import com.example.demo.service.PersonajeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    private final PersonajeServiceImp personajeService;

    public PersonajeController(PersonajeServiceImp personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("findByName/{n}")
    public ResponseEntity<?> findByName(@PathVariable String n) {
        return ResponseEntity.ok("Resultado de tu búsqueda" +personajeService.findByNombre(n));

    }
}
