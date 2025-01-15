package com.mercadolibre.javawave29.covid_19.controller;

import com.mercadolibre.javawave29.covid_19.model.RiskPersonDTO;
import com.mercadolibre.javawave29.covid_19.model.Symptom;
import com.mercadolibre.javawave29.covid_19.model.SymptomDTO;
import com.mercadolibre.javawave29.covid_19.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    private final CovidService covidService;

    @Autowired
    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> findSymptoms() {
        List<Symptom> symptoms = covidService.findSymptoms();
        if (symptoms.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(symptoms);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptoms(@PathVariable String name) {
        SymptomDTO symptom = covidService.findSymptomByName(name);
        if (symptom==null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(symptom);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPersons() {
        List<RiskPersonDTO> riskPersons = covidService.findRiskPeople();
        if (riskPersons==null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(riskPersons);
    }
}
