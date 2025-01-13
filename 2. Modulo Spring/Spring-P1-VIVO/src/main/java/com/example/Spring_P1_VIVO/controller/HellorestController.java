package com.example.Spring_P1_VIVO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellorestController {
    @GetMapping("/diHola/{nombre}")
    public String diHola(@PathVariable String nombre){
        return "Hola! " + nombre;
    }


}
