package org.example.hellorestcontroller.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/{name}")
    public String SayHello(@PathVariable String name){
        return "Hello World: " + name;
    }
}
