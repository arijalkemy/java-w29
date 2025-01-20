package com.example.calculadora_calorias.controller;

import com.example.calculadora_calorias.dto.request.DishInfoRequestDTO;
import com.example.calculadora_calorias.dto.response.DishInfoResponseDTO;
import com.example.calculadora_calorias.service.ICalculadoraCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CalculadoraCaloriasController {

    private final ICalculadoraCaloriasService service;

    @Autowired
    public CalculadoraCaloriasController(ICalculadoraCaloriasService service) {
        this.service = service;
    }

    @PostMapping("/dishes-info")
    public ResponseEntity<List<DishInfoResponseDTO>> getDishesInfo(@RequestBody List<DishInfoRequestDTO> dishesInfoRequest) {
        return ResponseEntity.ok(service.getDishesInfo(dishesInfoRequest));
    }
}
