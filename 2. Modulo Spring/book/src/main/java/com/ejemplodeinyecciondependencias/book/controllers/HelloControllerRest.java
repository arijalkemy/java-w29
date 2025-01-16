package com.ejemplodeinyecciondependencias.book.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerRest {

    @Value("${spring.mensaje}")
    String mensaje;
    @GetMapping("/hello")
    public String getMensaje(){
        return mensaje;
    }
}
