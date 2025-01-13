package com.edad_persona.edad_persona.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edad_persona.edad_persona.models.Person;
import com.edad_persona.edad_persona.services.PeopleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SavePeople {

    private final PeopleService peopleService;

    public SavePeople(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {

        this.peopleService.addPerson(person);

        return person;
    }

    @GetMapping("/calculateAge")
    public String getMethodName(@RequestParam String name) {

        return this.peopleService.calculatePersonAge(name);

    }

}
