package com.practicaanotaciones.practicadeanotaciones.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping (path = "{name}/{lastname}/{age}")
    public String soyHello(@PathVariable String name, @PathVariable String lastname, @PathVariable int age) {
        return "Hola " + name + " " + lastname + " Tu edad es: " + age;
    }
}
