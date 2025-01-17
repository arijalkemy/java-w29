package com.ejercicio.covid.controller;

import com.ejercicio.covid.model.Sintoma;
import com.ejercicio.covid.repository.SintomaRepository;
import com.ejercicio.covid.service.PersonaService;
import com.ejercicio.covid.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SintomasController {

    private SintomaService sintomaService;
    private PersonaService personaService;

    @Autowired
    public SintomasController(SintomaService sintomaService, PersonaService personaService) {
        this.sintomaService = sintomaService;
        this.personaService = personaService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> getSintomas() {
        return new ResponseEntity<>(this.sintomaService.getAllSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getSintomaByName(@PathVariable String name) {
        return new ResponseEntity<>(this.sintomaService.getSintomaByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getPersonasEnRiesgo() {
        return new ResponseEntity<>(this.personaService.getPersonasMayoresConSintomas(), HttpStatus.OK);
    }
}
