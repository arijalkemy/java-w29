package com.meli.practicaanotaciones.controller;

import com.meli.practicaanotaciones.DTO.AddEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam String name,
            @RequestParam String lastname
    ) {
        return "Hello " + name + " " + lastname;
    }

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(
            @RequestBody AddEmployeeDTO employee
    ) {
        return ResponseEntity.ok("Usuario creado con username: " + employee);
    }
}
