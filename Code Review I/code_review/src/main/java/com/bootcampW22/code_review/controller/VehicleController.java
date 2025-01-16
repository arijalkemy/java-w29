package com.bootcampW22.code_review.controller;

import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.dto.request.UpdateVehicleDto;
import com.bootcampW22.code_review.dto.response.ResponseVehicleDto;
import com.bootcampW22.code_review.service.IVehicleService;
import com.bootcampW22.code_review.service.VehicleServiceImpl;
import lombok.RequiredArgsConstructor;
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

    //Listar todos los vehículos
    @GetMapping
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.searchAllVehicles());
    }

    //Obtener un vehículo por id
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicleById(id));
    }

    //1. Añadir un vehículo
    @PostMapping
    public ResponseEntity<ResponseVehicleDto> addVehicle(@RequestBody VehicleDto newVehicle){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicle(newVehicle));
    }

    //2. Buscar vehículos por color y año
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getByColorAndYear(@PathVariable String color, @PathVariable Integer year){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getByColorAndYear(color, year));
    }

    //3. Buscar vehículos por marca y rango de años
    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getByBrandAndBetweenYears(@PathVariable String brand, @PathVariable Integer start_year, @PathVariable Integer end_year){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getByBrandAndBetweenYears(brand, start_year, end_year));
    }

    //5. Añadir múltiples vehículos
    @PostMapping("/batch")
    public ResponseEntity<ResponseVehicleDto> addVehicles(@RequestBody List<VehicleDto> newVehicles){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addVehicles(newVehicles));
    }

    //10. Actualizar el tipo de combustible de un vehículo
    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<ResponseVehicleDto> updateFuel(@PathVariable Long id, @RequestBody UpdateVehicleDto vehicle){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.updateFuel(id, vehicle));
    }

    //11. Obtener la capacidad promedio de personas por marca
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<ResponseVehicleDto> getAverageCapacityByBrand(@PathVariable String brand){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAverageCapacityByBrand(brand));
    }

    //12. Buscar vehículos por dimensiones
    @GetMapping("/dimensions?length={min_length}-{max_length}&width={min_width}-{max_width}")
    public ResponseEntity<List<VehicleDto>> getByDimensions(@PathVariable double min_length, @PathVariable double max_length,
                                                            @PathVariable double min_width, @PathVariable double max_width){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getByDimensions(min_length, max_length, min_width, max_width));
    }

    //13. Listar vehículos por rango de peso
    @GetMapping("/weight?min={weight_min}&max={weight_max}")
    public ResponseEntity<List<VehicleDto>> getByWeight(@PathVariable double weight_min, @PathVariable double weight_max){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getByWeight(weight_min, weight_max));
    }
}
