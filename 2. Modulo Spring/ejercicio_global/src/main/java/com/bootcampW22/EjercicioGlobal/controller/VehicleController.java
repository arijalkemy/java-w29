package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
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

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    // ejercicio 1
    @PostMapping("/")
    public ResponseEntity<?> addOne(@RequestBody VehicleDto dto) {
        return new ResponseEntity<>(vehicleService.addOne(dto), HttpStatus.CREATED);
    }

    // ejercicio 2
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> findAllByColorAndYear(@PathVariable String color,
                                                                  @PathVariable Integer year) {
        return new ResponseEntity<>(vehicleService.findAllByColorAndYear(color, year), HttpStatus.OK);
    }

    // ejercicio 3
    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<List<VehicleDto>> findAllByBrandAndBetweenYears(@PathVariable String brand,
                                                                          @PathVariable Integer startYear,
                                                                          @PathVariable Integer endYear) {
        return new ResponseEntity<>(vehicleService.findAllByBrandAndBetweenYears(brand, startYear, endYear), HttpStatus.OK);
    }

    // ejercicio 4
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<Double> getAverageSpeedOfBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAverageSpeedOfBrand(brand), HttpStatus.OK);
    }

    // ejercicio 5
    @GetMapping("/batch")
    public ResponseEntity<List<VehicleDto>> addVehicles(@RequestBody List<VehicleDto> vehicles) {
        return new ResponseEntity<>(vehicleService.addVehicles(vehicles), HttpStatus.OK);
    }

    // ejercicio 6
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<VehicleDto> updateSpeed(@PathVariable Long id,
                                                  @RequestParam Integer speed) {
        return new ResponseEntity<>(vehicleService.updateSpeed(id, speed), HttpStatus.OK);
    }

    // ejercicio 7
    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> findAllByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findAllByFuelType(type), HttpStatus.OK);
    }

    // ejercicio 8
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.deleteById(id), HttpStatus.NO_CONTENT);
    }

    // ejercicio 9
    @GetMapping("/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> findByTransmissionType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.findByTransmissionType(type), HttpStatus.OK);
    }

    // ejercicio 10
    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<VehicleDto> updateFuelById(@PathVariable Long id,
                                                     @RequestParam String fuel) {
        return new ResponseEntity<>(vehicleService.updateFuelById(id, fuel), HttpStatus.OK);
    }

    // ejercicio 11
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<Double> getAverageCapacityOfBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAverageCapacityOfBrand(brand), HttpStatus.OK);
    }

    // ejercicio 12
    @GetMapping("/dimensions")
    public ResponseEntity<List<VehicleDto>> findAllByDimensions(@RequestParam String height,
                                                                @RequestParam String width) {
        return new ResponseEntity<>(vehicleService.findAllByDimensions(height, width), HttpStatus.OK);
    }

    // ejercicio 13
    @GetMapping("/weight")
    public ResponseEntity<List<VehicleDto>> findAllByWeight(@RequestParam Double min,
                                                            @RequestParam Double max) {
        return new ResponseEntity<>(vehicleService.findAllByWeight(min, max), HttpStatus.OK);
    }


}
