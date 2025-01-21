package com.bootcamp.controller;

import com.bootcamp.dto.PersonajeDto;
import com.bootcamp.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("/{text}")
    public ResponseEntity<List<PersonajeDto>> findByText(@RequestParam String text) {
        return new ResponseEntity<>(personajeService.findByText(text), HttpStatus.OK);
    }


}
