package com.example.demo.controller;

import com.example.demo.service.CodigoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigomorse")
public class CodigoController {
    private final CodigoServiceImp codigoServiceImp;

    public CodigoController(CodigoServiceImp codigoServiceImp) {
        this.codigoServiceImp = codigoServiceImp;
    }

    @GetMapping("/{string}")
    public ResponseEntity<?> codigomorse(@PathVariable String string) {
        return ResponseEntity.ok("La frase " +string+ " se correponde al código: " +codigoServiceImp.generarCodigo(string));
    }
}
