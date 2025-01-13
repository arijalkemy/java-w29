package com.example.apisalud.controller;

import com.example.apisalud.model.dto.response.SymptomResponse;
import com.example.apisalud.model.entity.Symptom;
import com.example.apisalud.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
@RequiredArgsConstructor
public class SymptomRestController {
    private final SymptomService symptomService;

    @GetMapping("/")
    public ResponseEntity<List<Symptom>> getAll() {
        return ResponseEntity.ok(symptomService.getAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<SymptomResponse> getByName(@PathVariable String name) {
        return ResponseEntity.ok(symptomService.getByName(name));
    }
}
