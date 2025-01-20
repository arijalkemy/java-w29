package com.bootcamp.cardealership.controller;

import com.bootcamp.cardealership.dto.VehicleDTO;
import com.bootcamp.cardealership.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @GetMapping("dates")
    public ResponseEntity<?> getVehicleBetweenDates(@RequestParam("since") LocalDate from, @RequestParam("to") LocalDate to) {
        return ResponseEntity.ok(vehicleService.getBetweenDates(from, to));
    }

    @GetMapping("prices")
    public ResponseEntity<?> getVehiclesBetweenPrices(@RequestParam("since") Double from, @RequestParam("to") Double to) {
        return ResponseEntity.ok(vehicleService.getBetweenPrices(from, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable("id") String id) {
        VehicleDTO vehicleDTO = vehicleService.findById(id);
        if (vehicleDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vehicleDTO);
    }

}
