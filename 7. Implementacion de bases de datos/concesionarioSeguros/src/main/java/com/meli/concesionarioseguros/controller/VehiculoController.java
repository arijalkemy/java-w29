package com.meli.concesionarioseguros.controller;

import com.meli.concesionarioseguros.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/vehicles/patents")
    public ResponseEntity<?> getAllPatents(@RequestParam(value = "minWheels", required = false) Integer minWheels,
    @RequestParam(value = "year", required = false) Integer year){
        return new ResponseEntity<>(vehiculoService.findAllVehiclesPatents(minWheels,year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand-and-patents")
    public ResponseEntity<?> getAllPatentsAndBrands(
            @RequestParam(value = "sortOrder", required = false) String sortOrder){
        return new ResponseEntity<>(vehiculoService.findAllVehiclesPatentsAndBrands(sortOrder), HttpStatus.OK);
    }

    @GetMapping("/vehicles/accidents/details")
    public ResponseEntity<?> getVehiclesByAmountAccidentsDetails(
            @RequestParam(value = "minLoss", required = false) String minLoss){
        return new ResponseEntity<>(vehiculoService.findVehiclesByAmountAccidentsDetails(minLoss), HttpStatus.OK);
    }

    @GetMapping("vehicles/accidents/summary")
    public ResponseEntity<?> getVehiclesByAmountAccidentSummary(
            @RequestParam(value = "minLoss", required = false) String minLoss){
        return new ResponseEntity<>(vehiculoService.findVehiclesByAmountAccidentSummary(minLoss), HttpStatus.OK);
    }
 }
