package com.example.covid.controllers;

import com.example.covid.dto.PersonaDeRiesgoDTO;
import com.example.covid.dto.SintomaDTO;
import com.example.covid.services.IPersonaService;
import com.example.covid.services.ISintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sistemasalud")
public class SistemaController {
    private ISintomaService _sintomaService;
    private IPersonaService _personaService;

    public SistemaController(ISintomaService sintomaService, IPersonaService personaService){
        this._personaService = personaService;
        this._sintomaService = sintomaService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getSymptom(){
        return new ResponseEntity<>(this._sintomaService.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getSymptomByName(
            @PathVariable String name
    ){
        return new ResponseEntity<>(this._sintomaService.findSymptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDeRiesgoDTO>> getRiskPerson(){
        return new ResponseEntity<>(this._personaService.findRiskPerson(), HttpStatus.OK);
    }
}

