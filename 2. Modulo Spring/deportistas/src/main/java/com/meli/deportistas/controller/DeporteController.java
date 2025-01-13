package com.meli.deportistas.controller;

import com.meli.deportistas.model.Deporte;
import com.meli.deportistas.model.DeportistaDTO;
import com.meli.deportistas.service.DeporteService;
import com.meli.deportistas.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private DeporteService deporteService;
    @Autowired
    private DeportistaService deportistaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes() {
        return ResponseEntity.ok(deporteService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getDeporteByNombre(@PathVariable String name) {
        return ResponseEntity.ok(deporteService.findByNombre(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getAllDeportesPersons() {
        return ResponseEntity.ok(deportistaService.findAll());
    }

}
