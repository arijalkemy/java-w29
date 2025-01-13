package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.services.PeopleService;



@RestController
public class APIController {

    private int contador = 0;
    private PeopleService people = new PeopleService();

    @PostMapping("/add")
    public ResponseEntity<Integer> postMethodName(@RequestBody Person person) {
        contador = contador + 1;
        Person personToAdd = new Person(contador,person.getName(),person.getSurname(),person.getBirthDate());
        people.addPerson(personToAdd);
        return new ResponseEntity<Integer>(personToAdd.getId(),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Person>> getAllPeople() {
        return new ResponseEntity<List<Person>>(people.getAllPeople(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<Person>(people.getPersonById(id),HttpStatus.OK);
    }
    

    
}
