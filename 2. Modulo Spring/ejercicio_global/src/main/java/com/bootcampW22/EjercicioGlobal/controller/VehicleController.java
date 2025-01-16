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
