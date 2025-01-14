package com.thiagoschreck.local.symptom_finder.controller;

import com.thiagoschreck.local.symptom_finder.dto.PersonDTO;
import com.thiagoschreck.local.symptom_finder.dto.SymptomDTO;
import com.thiagoschreck.local.symptom_finder.service.SymptomFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class SymptomFinderController {

    @Autowired
    private SymptomFinderService symptomFinderService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> getAllSymptoms() {
        return ResponseEntity.ok(symptomFinderService.getAllSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomByName(@PathVariable String name) {
        final Optional<SymptomDTO> result = symptomFinderService.findSymptom(name);
        return new ResponseEntity<>(result.orElse(null),
                result.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTO>> getAllAtRiskPersons() {
        return ResponseEntity.ok(symptomFinderService.getAllAtRiskPersons());
    }
}
