package com.example.deportistas.controllers;

import com.example.deportistas.dtos.DeportistaDto;
import com.example.deportistas.models.Deporte;
import com.example.deportistas.services.DeportesService;
import com.example.deportistas.services.PersonasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final DeportesService deportesService;

    private final PersonasService personasService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes() {
        return ResponseEntity.ok(deportesService.getAllDeportes());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findByName(@PathVariable String name) {
        return ResponseEntity.ok(deportesService.getByName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto>> getAllPersonas() {
        return ResponseEntity.ok(personasService.findAllPersonas());
    }
}
