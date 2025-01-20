package com.example.ejercicio_contadorcalorias.controller;

import com.example.ejercicio_contadorcalorias.dto.request.PlatoDTO_In;
import com.example.ejercicio_contadorcalorias.dto.response.PlatoDTO_Out;
import com.example.ejercicio_contadorcalorias.service.IPlatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final IPlatoService platoService;

    @PostMapping("/calcular")
    public ResponseEntity<PlatoDTO_Out> calcularCalorias(@RequestBody PlatoDTO_In plato){
        return new ResponseEntity<>(this.platoService.calcularCalorias(plato), HttpStatus.OK) ;
    }

    @PostMapping("/calcularListado")
    public ResponseEntity<List<PlatoDTO_Out>> calcularCaloriasEnLista(@RequestBody List<PlatoDTO_In> platos){
        return new ResponseEntity<>(this.platoService.calcularCaloriasListado(platos), HttpStatus.OK) ;
    }
}