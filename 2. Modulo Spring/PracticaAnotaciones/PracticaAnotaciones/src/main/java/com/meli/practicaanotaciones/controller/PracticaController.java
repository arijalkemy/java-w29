package com.meli.practicaanotaciones.controller;

import com.meli.practicaanotaciones.DTO.AddEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PracticaController {

    @GetMapping (path = "/{name}/{lastname}/{age}")
    public String sayHello(
            @PathVariable String name,
            @PathVariable String lastname,
            @PathVariable int age
    ) {
        return "Hello " + name + " " + lastname + " " + age;
    }

    @GetMapping(path = "/student")
    public String sayHelloStudent(
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> lastname
    ) {
        return "Hello ";
    }

    @PostMapping("/employee")
    public ResponseEntity<AddEmployeeDTO> addEmployee(
            @RequestBody AddEmployeeDTO employee
    ) {
        return ResponseEntity.ok(employee);
    }
}
