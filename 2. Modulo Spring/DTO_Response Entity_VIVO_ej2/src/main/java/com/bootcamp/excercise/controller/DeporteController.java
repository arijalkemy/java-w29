package com.bootcamp.excercise.controller;

import com.bootcamp.excercise.dto.CustumerDTO;
import com.bootcamp.excercise.entity.DeporteEntity;
import com.bootcamp.excercise.service.IDeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class DeporteController {

    private final IDeporteService deporteService;
    private final IDeporteService personaService;

    public DeporteController(IDeporteService deporteService, IDeporteService personaService) {
        this.deporteService = deporteService;
        this.personaService = personaService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteEntity>> getAllSports() {
        List<DeporteEntity> deportes = deporteService.getAllSports();
        return ResponseEntity.ok(deportes);
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<String> getSportLevel(@PathVariable String nombre) {
        return deporteService.getSportLevelByName(nombre);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<CustumerDTO>> getSportsPersons() {
        List<CustumerDTO> deportistas = personaService.getAllSportsPersons();
        return ResponseEntity.ok(deportistas);
    }
}