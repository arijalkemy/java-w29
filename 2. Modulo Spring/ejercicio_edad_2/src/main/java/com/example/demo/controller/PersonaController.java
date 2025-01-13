package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/person")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> addPersona (@RequestBody Persona persona) {
        System.out.println(persona);
        personaService.savePersona(persona);
        return ResponseEntity.ok(persona);
    }

    @GetMapping(path = "/calcularEdad/{id}")
    public ResponseEntity<?> calcularEdad(@PathVariable Long id) {
        return ResponseEntity.ok("La edad de la persona es : " +personaService.calcularEdad(id));
    }

}
