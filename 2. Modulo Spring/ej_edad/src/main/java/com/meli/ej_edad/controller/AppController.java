package com.meli.ej_edad.controller;

import com.meli.ej_edad.dto.PersonDetailsDTO;
import com.meli.ej_edad.model.Person;
import com.meli.ej_edad.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class AppController {

    private final PersonService personService;

    @Autowired
    public AppController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAge(
            @PathVariable Integer day,
            @PathVariable Integer month,
            @PathVariable Integer year) {
        LocalDate birthday = LocalDate.of(year, month, day);
        Integer age = this.personService.calculateAge(birthday);
        return ResponseEntity.ok(String.format("Edad: %d años", age));
    }

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        Integer personId = this.personService.createPerson(person);
        return new ResponseEntity<String>("Persona creada con id: " + personId, HttpStatus.CREATED);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDetailsDTO> getPersonDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(this.personService.getPersonDetails(id));
    }
}
