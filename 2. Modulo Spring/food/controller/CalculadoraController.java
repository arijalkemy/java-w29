package com.api.food.controller;

import com.api.food.dto.CalculoResponseDTO;
import com.api.food.entity.Plato;
import com.api.food.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calorias")
public class CalculadoraController {
    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/calcular/{plato}/{peso}")
    public ResponseEntity<?> calcularCalorias(@PathVariable String plato, @PathVariable Integer peso) {
        CalculoResponseDTO responseDTO = service.calcularCalorias(plato, peso);
        return responseDTO != null ?  ResponseEntity.ok(responseDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping("/calcular/lista")
    public ResponseEntity<?> calcularCaloriasLista(@RequestBody List<Plato> platos) {
        //return ResponseEntity.ok(service.calcularCaloriasParaLista(platos));
        return null;
    }
}
