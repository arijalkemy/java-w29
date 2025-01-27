package com.bootcamp.excercise.controller;

import com.bootcamp.excercise.entity.PersonaRiesgoDto;
import com.bootcamp.excercise.entity.Sintoma;
import com.bootcamp.excercise.service.SaludService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaludController {
    private final SaludService saludService;

    public SaludController(SaludService saludService) {
        this.saludService = saludService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getAllSymtomps(){
        return ResponseEntity.ok(saludService.getAllSyntomps());
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSymptomLevel(@PathVariable("name") String nombre) {
        String level = saludService.getSymptomLevel(nombre);
        return ResponseEntity.ok(level);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDto>> getRiskPersons() {
        return ResponseEntity.ok(saludService.getRiskPersons());
    }
}
