package com.practicas.p1.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{año}")
    public ResponseEntity<String> getEdad(
            @PathVariable Integer dia,
            @PathVariable Integer mes,
            @PathVariable Integer año
    ) {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/hola")
    public ResponseEntity<String> getEdad(
    ) {
        return ResponseEntity.ok("Hello World");
    }

}
