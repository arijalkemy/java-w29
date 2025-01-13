package com.deportistas.deportistas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deportistas.deportistas.dto.DeportistaDto;
import com.deportistas.deportistas.models.Deporte;
import com.deportistas.deportistas.services.DeporteService;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeportesController {

    private final DeporteService deporteService;

    public DeportesController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes() {
        return ResponseEntity.ok(deporteService.getAllDeportes());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getDeporteByName(@PathVariable String name) {
        return deporteService.findDeporteByName(name)
                .map(deporte -> ResponseEntity.ok("Nivel: " + deporte.getNivel()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deporte no encontrado."));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto>> getAllDeportistas() {
        return ResponseEntity.ok(deporteService.getAllDeportistas());
    }
}
