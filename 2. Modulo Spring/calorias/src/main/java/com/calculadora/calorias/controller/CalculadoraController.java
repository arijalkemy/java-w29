package com.calculadora.calorias.controller;

import com.calculadora.calorias.service.CalculadoraServiceImpl;
import com.calculadora.calorias.service.IngredienteServiceImpl;
import com.calculadora.calorias.service.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("calculadora")
public class CalculadoraController {
    private IngredienteServiceImpl ingredienteService;
    private PlatoServiceImpl platoService;
    private CalculadoraServiceImpl calculadoraService;

    @Autowired
    public CalculadoraController(IngredienteServiceImpl ingredienteService, PlatoServiceImpl platoService, CalculadoraServiceImpl calculadoraService) {
        this.ingredienteService = ingredienteService;
        this.platoService = platoService;
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<?> getIngredientes() {
        return new ResponseEntity<>(ingredienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<?> getPlatos() {
        return new ResponseEntity<>(platoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("plato/{name}/{peso}")
    public ResponseEntity<?> calcularCalorias(@PathVariable String name, @PathVariable Double peso) {
        return new ResponseEntity<>(calculadoraService.calcularCalorias(name, peso), HttpStatus.OK);
    }
}
