package com.bootcampW22.EjercicioGlobal.controller;

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
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }


    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vechile) {
        return new ResponseEntity<>(vehicleService.addVehicle(vechile), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/{color}/{year}")
    public ResponseEntity<?> findByColorAndYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.getVehicleByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandAndYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year) {
        return new ResponseEntity<>(vehicleService.getVehicleByBrandAndYears(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/{brand}")
    public ResponseEntity<?> findAverageSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getSpeedByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addAllVehicles(@RequestBody List<VehicleDto> vehicles) {
        return new ResponseEntity<>(vehicleService.addAllVehicles(vehicles), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id, @RequestBody Double speed) {
        return new ResponseEntity<>(vehicleService.updateSpeed(id, speed), HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getByFuel(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehicleByFuel(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/vehicles/trasmission/{type}")
    public ResponseEntity<?> findbyTrasmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findByTrasmissionType(type), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getByDimensions(
            @RequestParam double min_length,
            @RequestParam double max_length,
            @RequestParam double min_width,
            @RequestParam double max_width) {

        return new ResponseEntity<>(vehicleService.findByMedidas(min_length, max_length, min_width, max_width), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<ResponseDto> updateFuel(@PathVariable Long id, @RequestBody String fuel) {
        return new ResponseEntity<>(vehicleService.updateFuel(id, fuel), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/{brand}")
    public ResponseEntity<?> getAvgCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.avgPersonByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/vehicles/weight")
    public  ResponseEntity<?> getVehicleByWeight(@RequestParam Double min, @RequestParam Double max)
    {
        return  new ResponseEntity<>(vehicleService.getVehicleByWeight(min,max),HttpStatus.OK);
    }
}
