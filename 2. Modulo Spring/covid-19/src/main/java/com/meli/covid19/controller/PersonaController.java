package com.meli.covid19.controller;
import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    PersonaService personaService;
    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPerson() {
        return personaService.getRiskPersonas();
    }
}
