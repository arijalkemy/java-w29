package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CovidController {
    private final SymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findAllSymptoms() {
        return ResponseEntity.ok(symptomService.findAllSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(symptomService.getSymptomRisk(name));
    }
}
