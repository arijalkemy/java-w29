package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.exception.*;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.InvalidSearchFilterException;
import java.util.List;

@RequestMapping("/vehicles")
@RestController
public class VehicleController {

    IVehicleService vehicleService;



    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }


    @GetMapping
    public ResponseEntity<?> getVehicles(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer since,
            @RequestParam(required = false) Integer to,
            @RequestParam(required = false) Integer year,
            @RequestParam(name = "fuel_type", required = false) String fuelType,
            @RequestParam(required = false) String transmission,
            @RequestParam(name = "min_length", required = false) Double minLength,
            @RequestParam(name = "max_length",required = false) Double maxLength,
            @RequestParam(name = "min_width",required = false) Double minWidth,
            @RequestParam(name = "max_width",required = false) Double maxWidth,
            @RequestParam(name = "weight_min",required = false) Double minWeight,
            @RequestParam(name = "weight_max",required = false) Double maxWeight

    ){ return vehicleService.findAll(brand, color, since, to, year, fuelType, transmission, minLength, maxLength, minWidth, maxWidth, minWeight, maxWeight); }

    @GetMapping("/average_speed")
    public ResponseEntity<List<AverageSpeedDTO>> getAverageSpeed (@RequestParam(required = false) String brands) { return vehicleService.getAverageSpeed(brands); }

    @GetMapping("/average_capacity")
    public ResponseEntity<List<AverageCapacityDTO>> getAverageCapacity (@RequestParam(required = false) String brands) { return vehicleService.getAverageCapacity(brands); }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle (@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) { return vehicleService.updateVehicle(id, vehicleDTO); }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable Long id) {
        return vehicleService.deleteVehicle(id);
    }



    @PostMapping
    public ResponseEntity<?> addVehicle (@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(body);
        if (jsonNode.isArray()) {
            List<VehicleDTO> vehicles = objectMapper.convertValue(jsonNode, new TypeReference<>() {});
            return vehicleService.addVehicle(vehicles);
        } else {
            VehicleDTO vehicle = objectMapper.treeToValue(jsonNode, VehicleDTO.class);
            return vehicleService.addVehicle(vehicle);
        }
    }

    @ExceptionHandler
    public ResponseEntity<AddVehicleDTO> handleException (AddVehicleException e) {
        AddVehicleDTO error = new AddVehicleDTO(e.getMessage(), e.getErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
