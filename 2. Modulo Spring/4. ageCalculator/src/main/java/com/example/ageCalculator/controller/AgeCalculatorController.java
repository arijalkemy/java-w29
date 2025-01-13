package com.example.ageCalculator.controller;

import com.example.ageCalculator.model.Person;
import com.example.ageCalculator.repository.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AgeCalculatorController {
    private PersonService personService = new PersonService();

    @GetMapping(path = "/{day}/{month}/{year}")
    public ResponseEntity<?> ageCalculator(@PathVariable int day,
                             @PathVariable int month,
                             @PathVariable int year) {
        return new ResponseEntity<>(personService.getYears(day, month, year), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<?> ageCalculatorByName(@PathVariable String name) {
        Person person = personService.getPersonByName(name);
        if (person != null) {
            return new ResponseEntity<>(person.getAge(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/save")
    private ResponseEntity<?> saveData(@RequestBody Person person) {
        person.setAge(personService.getYears(person.getDay(), person.getMonth(), person.getYear()));
        personService.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}
