package com.example.deportistas.controller;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final DeportistaService service;

    @Autowired
    public Controller(DeportistaService service) {
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes() {
        return ResponseEntity.ok(service.getAllDeportes());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findByName(@PathVariable String name) {
        try {
            Deporte deporte = service.findByName(name);
            return ResponseEntity.ok(deporte);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto>> getAllPersonas() {
        return ResponseEntity.ok(service.getAllPersonas());
    }

}
