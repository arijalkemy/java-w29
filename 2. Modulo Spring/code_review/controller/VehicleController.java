package org.example.code_review.controller;

import org.example.code_review.entity.Vehicle;
import org.example.code_review.service.IVehicleService;
import org.example.code_review.service.VehicleServiceImpl;
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
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable Integer year){
        return new ResponseEntity<>(vehicleService.getByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehiclesByBrandAndBetweenYears(@PathVariable String brand, @PathVariable Integer start_year, @PathVariable Integer end_year){
        return new ResponseEntity<>(vehicleService.getByBrandAndBetweenYears(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.getAverageByBrand(brand), HttpStatus.OK);
    }
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.getVehiclesByFuelType(type), HttpStatus.OK);
    }
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByTransmission(type), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam String height,
                                                     @RequestParam String width
                                                     ){
        String[] partsHeight = height.split("-");
        String[] partsWidth = width.split("-");

        double min_width = Double.parseDouble(partsWidth[0]);
        double max_width = Double.parseDouble(partsWidth[1]);
        double min_height = Double.parseDouble(partsHeight[0]);
        double max_height = Double.parseDouble(partsHeight[1]);

        return new ResponseEntity<>(vehicleService.getVehiclesByDimensions(min_height, max_height, min_width, max_width), HttpStatus.OK);
    }


    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.CREATED);
    }
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addVehicle(@RequestBody List <Vehicle> vehicles){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicles), HttpStatus.CREATED);
    }
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable Long id ,@RequestBody Double newSpeed){
        return new ResponseEntity<>(vehicleService.updateSpeed(id, newSpeed), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuelType(@PathVariable Long id ,@RequestBody String newFuelType){
        this.vehicleService.updateFuelType(id, newFuelType);
        return new ResponseEntity<>("Fuel updated", HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
