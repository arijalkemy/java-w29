package com.example.star_wars_ejercicio.controller;

import com.example.star_wars_ejercicio.dto.PersonajeDTO;
import com.example.star_wars_ejercicio.service.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarWarsController {
    private StarWarsService starWarsService;

    //Inyecta automáticamente el servicio (StarWarsService) en el controlador. Si tu controlador tiene un constructor como el que muestras
    //Spring verá que el controlador tiene una dependencia de StarWarsService y buscará un bean de tipo StarWarsService para inyectarlo.
    //Si StarWarsService está marcado con la anotación @Service, Spring sabe que debe crear una instancia de StarWarsService y la pasa al controlador.
    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> obtenerListaPersonajes(@PathVariable String nombre) {
        return new ResponseEntity<>(starWarsService.buscarPersonajes(nombre), HttpStatus.OK);
    }
}
