package com.example.vehicles.controller;

import com.example.vehicles.service.IAccidentService;
import com.example.vehicles.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @GetMapping("/patents")
    ResponseEntity<?> getAllPatents() {
        return ResponseEntity.ok(vehicleService.getAllPatents());
    }

    @GetMapping("/patents_brands")
    ResponseEntity<?> getAllPatentsAndBrandsOrderByYear() {
        return ResponseEntity.ok(vehicleService.getAllPatentsAndBrandsOrderByYear());
    }

    @GetMapping("/patents_wheels")
    ResponseEntity<?> getPatentsFromVehiclesWithFourWheelsAndCurrentYear() {
        return ResponseEntity.ok(vehicleService.getPatentsFromVehiclesWithFourWheelsAndCurrentYear());
    }

    @GetMapping("/patents_accident_loss")
    ResponseEntity<?> getPatentBrandModelVehiclesWithOneAccidentAndLoss() {
        return ResponseEntity.ok(vehicleService.getPatentBrandModelVehiclesWithOneAccidentAndLoss());
    }

    @GetMapping("/patents_accident_loss_sum")
    ResponseEntity<?> getPatentBrandModelVehiclesWithOneAccidentAndLossAndSum() {
        return ResponseEntity.ok(vehicleService.getPatentBrandModelVehiclesWithOneAccidentAndLossAndSum());
    }
}
