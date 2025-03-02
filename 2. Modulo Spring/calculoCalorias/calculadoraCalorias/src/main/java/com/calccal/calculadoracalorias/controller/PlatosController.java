package com.calccal.calculadoracalorias.controller;

import com.calccal.calculadoracalorias.dto.IngredienteDTO;
import com.calccal.calculadoracalorias.dto.PlatoDTO;
import com.calccal.calculadoracalorias.model.Ingrediente;
import com.calccal.calculadoracalorias.service.IPlatosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatosController {

    IPlatosService iPlatosService;

    public PlatosController(IPlatosService iPlatosService){
        this.iPlatosService = iPlatosService;
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<IngredienteDTO>> getAllIngredientes(){
        return new ResponseEntity<>(iPlatosService.findAllIngr(), HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<List<PlatoDTO>> getAllPlatos(){
        return new ResponseEntity<>(iPlatosService.findAllPlatos(), HttpStatus.OK);
    }

    @GetMapping("/calorias/{nombrePlato}")
    public ResponseEntity<?> getCaloriasPorPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<>(iPlatosService.findCaloriasPorPlato(nombrePlato), HttpStatus.OK);
    }

    @GetMapping("/{nombrePlato}")
    public ResponseEntity<List<IngredienteDTO>> getInfoPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<>(iPlatosService.findInfoPorPlato(nombrePlato), HttpStatus.OK);
    }

    @GetMapping("/ingrediente/calorias/{nombrePlato}")
    public ResponseEntity<IngredienteDTO> getMayorCaloriaPlato(@PathVariable String nombrePlato){
        return new ResponseEntity<>(iPlatosService.findIngredienteConMasCalorias(nombrePlato), HttpStatus.OK);
    }
}
