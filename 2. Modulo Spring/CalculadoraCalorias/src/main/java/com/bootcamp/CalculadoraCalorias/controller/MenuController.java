package com.bootcamp.CalculadoraCalorias.controller;

import com.bootcamp.CalculadoraCalorias.dto.CaloriasPorPlatoDTO;
import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.service.PlatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final PlatoService platoService;

    @GetMapping("calorias/{nombre}/{peso}")
    public ResponseEntity<CaloriasPorPlatoDTO> calcularCalorias(@PathVariable String nombre, @PathVariable Double peso) {
        return ResponseEntity.ok().body(platoService.calcularCaloriasPorPlatoYPeso(nombre, peso));
    }

    @GetMapping("plato/{nombre}/ingrediente")
    public ResponseEntity<List<IngredienteDTO>> obtenerIngredientes(@PathVariable String nombre) {
        return ResponseEntity.ok().body(platoService.obtenerIngredientes(nombre));
    }

    @GetMapping("plato/{nombre}/ingrediente/max")
    public ResponseEntity<IngredienteDTO> obtenerIngredienteConMasCalorias(@PathVariable String nombre) {
        return ResponseEntity.ok().body(platoService.obtenerIngredienteConMasCalorias(nombre));
    }

}
