package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
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

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }
    //End point #1
    @PostMapping("/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle){
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //End point #2
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(@PathVariable("color") String color, @PathVariable("year") int year){
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color,year), HttpStatus.OK);
    }
    //End point #3
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehicleByBrandAndDates(@PathVariable String brand, @PathVariable("start_year") int startYear, @PathVariable("end_year") int endYear){
        return new ResponseEntity<>(vehicleService.searchByBrandAndDates(brand,startYear,endYear),HttpStatus.OK);
    }
    //End point #4
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<AverageSpeedDto> getAverageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAverageSpeedByBrand(brand),HttpStatus.OK);
    }
    //End point #5
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addBatchVehicles(@RequestBody List<VehicleDto> vehicleDtos){
        vehicleService.addListOfVehicles(vehicleDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //End point #6
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody String speed){
        vehicleService.updateVehicleSpeed(id,speed);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //End point #7
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByFuelType(type),HttpStatus.OK);
    }
    //End point #8
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        vehicleService.removeVehicle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //End point #9
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByTransmission(type),HttpStatus.OK);
    }
    //End point #10
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateVehicleFuel(@PathVariable Long id, @RequestBody String fuel){
        vehicleService.updateVehicleFuelType(id, fuel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //End point #11
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<Double> getAverageCapacity(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.searchAverageCapacity(brand),HttpStatus.OK);
    }
    //End point #12
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehicleByDimensions(@RequestParam("length") String lengthRange, @RequestParam("width") String widthRange) {
        return new ResponseEntity<>(vehicleService.searchVehiclesByDimensions(lengthRange,widthRange),HttpStatus.OK);
    }
    //End point #13
    @GetMapping("/vehicles/weight")
    public ResponseEntity<List<VehicleDto>> getVehiclesByWeights(@RequestParam Double min,@RequestParam Double max){
        return new ResponseEntity<>(vehicleService.searchVehicleByWeight(min,max),HttpStatus.OK);
    }
}
