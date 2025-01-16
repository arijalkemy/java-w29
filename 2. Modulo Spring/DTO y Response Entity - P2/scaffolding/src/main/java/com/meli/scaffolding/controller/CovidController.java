package com.meli.scaffolding.controller;

import com.meli.scaffolding.dto.PersonaDto;
import com.meli.scaffolding.dto.SintomaDto;
import com.meli.scaffolding.services.ICovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CovidController {
    private final ICovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> sintomas(){
        return new ResponseEntity<>(covidService.sintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> nivelDeGravedad(@PathVariable String name){
        return new ResponseEntity<>(covidService.nivelDeGravedad(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> getRiskPersons() {
        List<PersonaDto> personaDtos = covidService.getRiskPersons();
        return ResponseEntity.ok(personaDtos);
    }
}
