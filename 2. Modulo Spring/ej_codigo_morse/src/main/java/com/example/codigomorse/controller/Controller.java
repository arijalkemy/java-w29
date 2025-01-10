package com.example.codigomorse.controller;

import com.example.codigomorse.service.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final CodigoMorseService service;

    @Autowired
    public Controller(CodigoMorseService service) {
        this.service = service;
    }

    @PostMapping("/fromMorse")
    public ResponseEntity<String> fromMorse(@RequestBody String codigoMorse) {
        try {
            String resultado = service.fromMorse(codigoMorse);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
