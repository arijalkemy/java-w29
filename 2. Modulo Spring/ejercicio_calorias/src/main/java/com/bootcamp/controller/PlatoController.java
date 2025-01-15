package com.bootcamp.controller;

import com.bootcamp.dto.response.IngredienteDto;
import com.bootcamp.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoController {

    @Autowired
    private IPlatoService platoService;

    @GetMapping("/calorias/{nombre}")
    public ResponseEntity<String> getCantidadTotalCaloriasPlato(@PathVariable String nombre) {
        Double calorias = platoService.getCantidadTotalCaloriasPlato(nombre);
        if (calorias == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok("Total de calorias: " + calorias);
    }

    @GetMapping("/ingrediente/{nombre}")
    public ResponseEntity<List<IngredienteDto>> getListaIngredientesYCalorias(@PathVariable String nombre) {
        List<IngredienteDto> ingredientes = platoService.getListaIngredientesYCalorias(nombre);
        if (ingredientes.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(ingredientes, HttpStatus.OK);
    }

    @GetMapping("/ingrediente/max_caloria/{nombre}")
    public ResponseEntity<IngredienteDto> getIngredienteMayorCalorias(@PathVariable String nombre) {
        IngredienteDto dto = platoService.getIngredienteMayorCalorias(nombre);
        if (dto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }





}

