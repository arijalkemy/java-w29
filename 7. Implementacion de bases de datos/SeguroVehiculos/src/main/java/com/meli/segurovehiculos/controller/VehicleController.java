package com.meli.segurovehiculos.controller;

import com.meli.segurovehiculos.dto.VehicleDto;
import com.meli.segurovehiculos.service.vehicle.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return new ResponseEntity<>(this.vehicleService.getAllVehicles(), HttpStatus.OK);
    }

}
