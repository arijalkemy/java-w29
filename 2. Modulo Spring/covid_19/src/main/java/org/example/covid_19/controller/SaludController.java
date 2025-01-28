package org.example.covid_19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.example.covid_19.dots.PersonaYSintomaDto;
import org.example.covid_19.entity.Sintoma;
import org.example.covid_19.services.SaludService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SaludController {

    private final SaludService saludService;

    @Autowired
    public SaludController(SaludService saludService) {
        this.saludService = saludService;
    }

    @GetMapping("/findSymptom")
    public List<Sintoma> getAllSymptoms() {
        return saludService.findAllSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSymptomByName(@PathVariable String name) {
        return saludService.findSymptomByName(name);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaYSintomaDto> getRiskPersons() {
        return saludService.findRiskPersons();
    }
}
