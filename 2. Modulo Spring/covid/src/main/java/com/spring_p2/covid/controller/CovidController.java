package com.spring_p2.covid.controller;

import com.spring_p2.covid.dto.RiskPersonDTO;
import com.spring_p2.covid.dto.SymptomDTO;
import com.spring_p2.covid.model.Symptom;
import com.spring_p2.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class CovidController {
    @Autowired
    CovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom() {
        return ResponseEntity.ok(covidService.getSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name) {
        Optional<SymptomDTO> foundSymptom = covidService.getSymptomByName(name);
        return foundSymptom.isPresent()
            ? ResponseEntity.ok("Symptom severity: " + foundSymptom.get().severity())
            : ResponseEntity.notFound().build();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPerson() {
        return ResponseEntity.ok(covidService.getRiskPersons());
    }
}
