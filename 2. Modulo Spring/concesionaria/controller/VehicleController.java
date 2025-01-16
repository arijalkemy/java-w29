package com.api.concesionaria.controller;

import com.api.concesionaria.entity.Vehicle;
import com.api.concesionaria.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> addVehicle(@RequestBody Vehicle vehicle) {
        service.addVehicle(vehicle);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = service.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
        Vehicle vehicle = service.getVehicleById(id);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Vehicle>> getVehiclesByDateRange(
            @RequestParam String since, @RequestParam String to) {
        List<Vehicle> vehicles = service.getVehiclesByDateRange(since, to);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Vehicle>> getVehiclesByPriceRange(
            @RequestParam double since, @RequestParam double to) {
        List<Vehicle> vehicles = service.getVehiclesByPriceRange(since, to);
        return ResponseEntity.ok(vehicles);
    }
}
