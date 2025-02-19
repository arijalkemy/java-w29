package com.bootcamp.accidented_vehicles.controller;

import com.bootcamp.accidented_vehicles.dto.VehicleDto;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentAndModel;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentBrandModelDto;
import com.bootcamp.accidented_vehicles.dto.VehiclePatentBrandModelWithTotalDto;
import com.bootcamp.accidented_vehicles.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private final IVehicleService service;

    @Autowired
    public VehicleController(IVehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(service.saveVehicle(vehicleDto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles(){
        return ResponseEntity.ok(service.findAllVehicles());
    }

    @GetMapping("/patent")
    public ResponseEntity<List<String>> getAllPatents(){
        return ResponseEntity.ok(service.findAllPatents());
    }

    @GetMapping("/patent/brand")
    public ResponseEntity<List<VehiclePatentAndModel>> getAllPatentsAndBrand(){
        return ResponseEntity.ok(service.getAllPatentsAndBrand());
    }

    @GetMapping("/punto3")
    public ResponseEntity<List<String>> getAllPatentsFromCurrentYearAndWheelsGreaterThan4(){
        return ResponseEntity.ok(service.getAllPatentsFromCurrentYearAndWheelsGreaterThan4());
    }

    @GetMapping("/punto4")
    public ResponseEntity<List<VehiclePatentBrandModelDto>> getAllPatentBrandModelWithLossGreaterThan10000(){
        return ResponseEntity.ok(service.getAllPatentBrandModelWithLossGreaterThan10000());
    }

    @GetMapping("/punto5")
    public ResponseEntity<VehiclePatentBrandModelWithTotalDto> getAllPatentBrandModelWithLossGreaterThan10000AndTotalLoss(){
        return ResponseEntity.ok(service.getAllPatentBrandModelWithLossGreaterThan10000AndTotalLoss());
    }
}
