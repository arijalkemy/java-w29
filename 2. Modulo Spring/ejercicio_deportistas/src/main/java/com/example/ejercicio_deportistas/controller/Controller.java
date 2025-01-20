package com.example.ejercicio_deportistas.controller;

import com.example.ejercicio_deportistas.service.DeporteService;
import com.example.ejercicio_deportistas.service.DeportistaService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping({"/encontrarDeportes"})
public class Controller {
    private final DeporteService deporteService;
    private final DeportistaService deportistaService;

    @GetMapping({"/"})
    public ResponseEntity<?> mostrarDeportes() {
        return new ResponseEntity<>(deporteService.encontrarTodos(), HttpStatus.OK);
    }

    @GetMapping({"/{nombre}"})
    public ResponseEntity<?> mostrarDeportePorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(deporteService.encontrarPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping({"/{nombre}/deportistas"})
    public ResponseEntity<?> mostrarDeportistasPorDeporte(@PathVariable String nombre) {
        return new ResponseEntity<>(deportistaService.encontrarDeportistasPorDeporte(nombre), HttpStatus.OK);
    }
}