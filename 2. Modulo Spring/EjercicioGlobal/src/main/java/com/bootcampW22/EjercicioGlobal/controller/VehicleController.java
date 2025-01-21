package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.request.MaxSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.response.GenericResponseDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<GenericResponseDto> updateVehicleMaxSpeed(@PathVariable Long id, @RequestBody MaxSpeedDto maxSpeedDto){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.updateMaxSpeed(id, maxSpeedDto));
    }
}
