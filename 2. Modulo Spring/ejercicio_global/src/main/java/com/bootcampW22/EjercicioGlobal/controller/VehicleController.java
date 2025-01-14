package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addOne(@RequestBody VehicleDto dto){
        Vehicle vehicle = vehicleService.addOne(dto);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> findAllByColorAndYear(@PathVariable String color,
                                                       @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.findAllByColorAndYear(color, year), HttpStatus.OK);
    }




}
