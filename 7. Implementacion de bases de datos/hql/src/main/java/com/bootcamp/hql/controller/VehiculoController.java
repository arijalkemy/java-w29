package com.bootcamp.hql.controller;

import com.bootcamp.hql.dto.VehiculoDto;
import com.bootcamp.hql.service.IVehiculoService;
import com.bootcamp.hql.service.VehiculoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/vehiculo")
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoDto vehiculoDto) {
        VehiculoDto newVehiculo = vehiculoService.createVehiculo(vehiculoDto);
        return new ResponseEntity<>(newVehiculo, HttpStatus.CREATED);
    }

    @GetMapping("/vehiculo/{id}")
    public ResponseEntity<?> getVehiculo(@PathVariable Long id) {
        VehiculoDto vehiculo = vehiculoService.getVehiculo(id);
        return new ResponseEntity<>(vehiculo, HttpStatus.OK);
    }

    @GetMapping("/vehiculo/plates")
    public ResponseEntity<?> findAllPlates() {
        return new ResponseEntity<>(vehiculoService.findAllPlates(), HttpStatus.OK);
    }

    @GetMapping("/vehiculo/license-plate-brand")
    public ResponseEntity<?> findLicensePlateAndBrand() {
        return new ResponseEntity<>(vehiculoService.findLicensePlateAndBrand(), HttpStatus.OK);
    }

    @GetMapping("/vehiculo/plates-more-than-four-wheels")
    public ResponseEntity<?> findPlatesByVehicleWithMoreThanFourWheels() {
        return new ResponseEntity<>(vehiculoService.findPlatesByVehicleWithMoreThanFourWheels(), HttpStatus.OK);
    }
}