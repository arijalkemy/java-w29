package org.bootcamp.codereviewtest.controller;

import org.bootcamp.codereviewtest.dto.VehicleDto;
import org.bootcamp.codereviewtest.service.IVehicleService;
import org.bootcamp.codereviewtest.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByBrandAndBetweenYears(@PathVariable String brand,
                                                                              @PathVariable(name="start_year") Integer startYear,
                                                                              @PathVariable(name="end_year") Integer endYear){
        return new ResponseEntity<>(vehicleService.searchByBrandAndBetweenYears(brand, startYear, endYear), HttpStatus.OK);
    }
}
