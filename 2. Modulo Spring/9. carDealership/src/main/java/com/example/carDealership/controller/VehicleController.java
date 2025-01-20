package com.example.carDealership.controller;

import com.example.carDealership.dto.VehicleDto;
import com.example.carDealership.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    private ResponseEntity<?> addNewVehicle(@RequestBody VehicleDto vehicle) {
        return new ResponseEntity<>(vehicleService.addNewVehicle(vehicle), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<?> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    private ResponseEntity<?> getVehiclesByDate(@RequestParam String since, @RequestParam String to) {
        return new ResponseEntity<>(vehicleService.geAllVehiclesByManufacturingDate(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    private ResponseEntity<?> getVehiclesByPrice(@RequestParam Double since, @RequestParam Double to) {
        return new ResponseEntity<>(vehicleService.geAllVehiclesByPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getVehiclesByPrice(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.findVehicle(id), HttpStatus.OK);
    }
}
