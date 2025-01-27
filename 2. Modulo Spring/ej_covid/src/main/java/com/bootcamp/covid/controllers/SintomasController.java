package com.bootcamp.covid.controllers;

import com.bootcamp.covid.dtos.SintomaDto;
import com.bootcamp.covid.services.SintomasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sintomas")
@RequiredArgsConstructor
public class SintomasController {

    private final SintomasService service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> getAllSintomas() {
        return ResponseEntity.ok(service.getAllSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findGravedadByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findGravedadByName(name));
    }

}
