package com.example.deportes.controller;

import com.example.deportes.model.dto.response.AthleteResponse;
import com.example.deportes.model.entity.Person;
import com.example.deportes.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonRestController {
    private final PersonService personService;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/athletes")
    public ResponseEntity<List<AthleteResponse>> getAllAthletes() {
        return ResponseEntity.ok(personService.getAllAthletes());
    }

}
