package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
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

    @GetMapping()
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> addVehicles(@RequestBody VehicleDto vehicle){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicle),HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByBrandAndYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.searchVehiclesByBrandAndYears(brand, start_year,end_year), HttpStatus.OK);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<AverageSpeedDto> getAverageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeedByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<ResponseDto> addBatchVehicles(@RequestBody List<VehicleDto> vehicles){
        return new ResponseEntity<>(vehicleService.addBatchVehicles(vehicles),HttpStatus.OK);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<ResponseDto> updateSpeedById(@PathVariable Long id, @RequestParam String speed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, speed),HttpStatus.OK);
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehiclesByFuel(type),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }

    @GetMapping("/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTransmission(@PathVariable String type){
        return  new ResponseEntity<>(vehicleService.getVehiclesByTransmission(type),HttpStatus.OK);
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<ResponseDto> updateFuelById(@PathVariable Long id, @RequestParam String fuel){
        return new ResponseEntity<>(vehicleService.updateFuel(id, fuel),HttpStatus.OK);
    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<AverageCapacityDto> getAverageCapacityByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageCapacityByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehiclesByDimensions(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>(vehicleService.getVehiclesByDimensions(length, width),HttpStatus.OK);
    }

    @GetMapping("/weight")
    public ResponseEntity<List<VehicleDto>> getVehiclesByWeight(@RequestParam Integer min, @RequestParam Integer max){
        return new ResponseEntity<>(vehicleService.getVehiclesByWeight(min, max),HttpStatus.OK);
    }

}
