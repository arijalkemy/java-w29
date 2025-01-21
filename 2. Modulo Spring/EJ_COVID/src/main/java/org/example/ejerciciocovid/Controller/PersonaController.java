package org.example.ejerciciocovid.Controller;

import lombok.RequiredArgsConstructor;
import org.example.ejerciciocovid.Dtos.PersonaRiesgoDto;
import org.example.ejerciciocovid.Services.PersonaService;
import org.example.ejerciciocovid.Services.PersonaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaServiceImpl service;

    public  PersonaController(PersonaServiceImpl service)
    {
        this.service = service;
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDto>> getPersonasRiesgo() {
        return ResponseEntity.ok(service.getPersonasRiesgo());
    }
}
