package com.meli.ej_deportistas.controller;


import com.meli.ej_deportistas.dto.PersonaDeporteDTO;
import com.meli.ej_deportistas.model.Deporte;
import com.meli.ej_deportistas.service.DeporteService;
import com.meli.ej_deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    private final DeporteService deporteService;
    private final PersonaService personaService;

    @Autowired
    public AppController(DeporteService deporteService, PersonaService personaService) {
        this.deporteService = deporteService;
        this.personaService = personaService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeportes() {
        return ResponseEntity.ok(this.deporteService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getDeporte(@PathVariable String name) {
        return ResponseEntity.ok(this.deporteService.findByNombre(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> getDeportesPersonas() {
        return ResponseEntity.ok(this.personaService.findAllPersonasDeportistas());
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam String nombre) {
        System.out.println(nombre);
        return ResponseEntity.ok("Hello " + nombre);
    }
}
