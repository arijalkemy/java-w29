package com.example.demo.controller;

import com.example.demo.service.NumeroServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nroromano")
public class NumeroController {

    private final NumeroServiceImpl numeroServiceImpl;

    public NumeroController(NumeroServiceImpl numeroServiceImpl) {
        this.numeroServiceImpl = numeroServiceImpl;
    }

    @GetMapping("/{nro}")
    public ResponseEntity<?> tranformarnroromano(@PathVariable Long nro) {
       return ResponseEntity.ok("El nro : " +nro + " en romano es : " +numeroServiceImpl.transformar(nro));
    }
}
