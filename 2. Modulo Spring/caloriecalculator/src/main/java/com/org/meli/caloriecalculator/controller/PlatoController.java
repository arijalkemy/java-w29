package com.org.meli.caloriecalculator.controller;

import com.org.meli.caloriecalculator.dto.IngredienteDto;
import com.org.meli.caloriecalculator.dto.PlatoDto;
import com.org.meli.caloriecalculator.service.IIngredienteService;
import com.org.meli.caloriecalculator.service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    private final IPlatoService platoService;

    public PlatoController(IPlatoService platoService, IIngredienteService ingredienteService) {
        this.platoService = platoService;
    }

    @GetMapping("/platos/{nombrePlato}/calorias/{cantidad}")
    public ResponseEntity<String> caloriasTotalesPlatos(@PathVariable String nombrePlato, @PathVariable Integer cantidad){
        return new ResponseEntity<>(platoService.caloriasTotalesPlatos(nombrePlato,cantidad), HttpStatus.OK);
    }

    @GetMapping("/platos/{nombrePlato}/ingredientes")
    public ResponseEntity<PlatoDto> mostrarIngredientesdePlato(@PathVariable String nombrePlato){
        return new ResponseEntity<>(platoService.mostrarIngredientesdePlato(nombrePlato), HttpStatus.OK);
    }

    @GetMapping("/platos/mas-calorias/{nombrePlato}")
    public ResponseEntity<IngredienteDto> buscarIngredienteConMasCalorias(@PathVariable String nombrePlato){
        return new ResponseEntity<>(platoService.buscarIngredienteConMasCalorias(nombrePlato), HttpStatus.OK);
    }
}
