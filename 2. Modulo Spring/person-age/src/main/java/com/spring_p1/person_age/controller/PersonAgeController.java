package com.spring_p1.person_age.controller;

import com.spring_p1.person_age.model.Person;
import com.spring_p1.person_age.service.PersonAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class PersonAgeController {
    @Autowired
    PersonAgeService personAgeService;

    @GetMapping(path = "/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(
        @PathVariable int day,
        @PathVariable int month,
        @PathVariable int year
    ) {
        return new ResponseEntity<>(personAgeService.getAgeFromDDMMYYYY(day, month, year), HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personAgeService.addPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<String> getPersonAge(@PathVariable Integer id) {
        Optional<Person> personRetieved = personAgeService.getPerson(id);
        return personRetieved.isPresent()
                ? new ResponseEntity<>("Person age is " + personAgeService.getAge(personRetieved.get()), HttpStatus.OK)
                : new ResponseEntity<>("Person with that id does not exist", HttpStatus.NOT_FOUND);
    }
}
