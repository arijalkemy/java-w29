package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.service.IVehicleService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class VehicleController {
    private final IVehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeight(
      @RequestParam Double min,
      @RequestParam Double max
    ){
      vehicleService.searchVehiclesByWeight(min, max);
      return ResponseEntity.ok().body(vehicleService.searchVehiclesByWeight(min, max));
    }
}
