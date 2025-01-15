package com.meli.deportistas.controller;

import com.meli.deportistas.dto.PersonaDto;
import com.meli.deportistas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping("/findSportsPersons")
    public List<PersonaDto> getPersonaSport (){
        return  personaService.getAllPersonasDto();
    }
}
