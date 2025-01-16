package com.bootcampW22.code_review.controller;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.dto.response.NewVehicleDto;
import com.bootcampW22.code_review.service.IVehicleService;
import com.bootcampW22.code_review.service.VehicleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    //Listar todos los vehículos
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.searchAllVehicles());
    }

    //1. Añadir un vehículo
    @PostMapping("/vehicles")
    public ResponseEntity<NewVehicleDto> addVehicle(@RequestBody VehicleDto newVehicle){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicle(newVehicle));
    }
}
