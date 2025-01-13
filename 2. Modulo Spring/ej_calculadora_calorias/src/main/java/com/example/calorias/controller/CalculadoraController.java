package com.example.calorias.controller;

import com.example.calorias.service.CalculadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalculadoraController {

    private final CalculadoraService service;

    @GetMapping("/calorias/{plato}")
    public ResponseEntity<Integer> getCalorias(@PathVariable String plato) {
        return ResponseEntity.ok(service.getCalorias(plato));
    }

    @GetMapping("/ingredientes/{plato}")
    public ResponseEntity<List<String>> getIngredientes(@PathVariable String plato) {
        return ResponseEntity.ok(service.getIngredientes(plato));
    }

}
