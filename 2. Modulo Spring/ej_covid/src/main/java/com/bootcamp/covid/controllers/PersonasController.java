package com.bootcamp.covid.controllers;

import com.bootcamp.covid.dtos.PersonaRiesgoDto;
import com.bootcamp.covid.services.PersonasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonasController {

    private final PersonasService service;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDto>> getPersonasRiesgo() {
        return ResponseEntity.ok(service.getPersonasRiesgo());
    }

}
