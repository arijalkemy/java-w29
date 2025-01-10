package com.example.primer_proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @GetMapping // todas las peticiones que lleguen, se mapean
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/{name}") // todas las peticiones que lleguen, se mapean
    public String sayHelloName(@PathVariable String name){
        return "Hello " + name;
    }

}
