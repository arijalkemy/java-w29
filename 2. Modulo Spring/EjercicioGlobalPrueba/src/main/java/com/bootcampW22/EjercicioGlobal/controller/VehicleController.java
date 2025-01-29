package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle){
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>("ID agregado" + vehicle.getId(),HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.getByColorYear(color,year),HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getVelocityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getVelocityByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addBatchVehicles(@RequestBody List<Vehicle> vehicles){
        return new ResponseEntity<>(vehicleService.addBatchVehicles(vehicles), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestParam String newMaxSpeed){
        return new ResponseEntity<>("Velocidad actualizada correctamente",HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getFuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>("vehiculo eliminado correctamente", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?>dimensionVehicle(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>(vehicleService.dimensionVehicle(length, width), HttpStatus.OK);
    }
}
