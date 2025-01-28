package org.example.calcular_calorias.controllers;

import org.example.calcular_calorias.dtos.CaloriasTotalesDto;
import org.example.calcular_calorias.dtos.IngredientesDto;
import org.example.calcular_calorias.dtos.PlatosDto;
import org.example.calcular_calorias.services.ICalcularCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {
    @Autowired
    private ICalcularCaloriasService calcularCaloriasService;

    @PostMapping("/calorias")
    public ResponseEntity<CaloriasTotalesDto> calcularCalorias(@RequestBody PlatosDto platosDto) {
        CaloriasTotalesDto respuesta = calcularCaloriasService.calcularCalorias(platosDto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/ingredienteMasCalorico/{nombre}")
    public ResponseEntity<IngredientesDto> obtenerIngredienteConMasCalorias(@PathVariable String nombre){
        IngredientesDto ingredienteMasCalorico = calcularCaloriasService.obtenerIngredienteConMasCalorias(nombre);
        return new ResponseEntity<>(ingredienteMasCalorico, HttpStatus.OK);
    }
}
