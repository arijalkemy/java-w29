package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.AverageVehiclesDto;
import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
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

    //Ver vehiculo
    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    //[US-0001] Agregar vehiculo
    @PostMapping("/vehicles")
    public ResponseEntity<ExceptionDto> addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehiculo(vehicle);
    }

    //[US-0002] Buscar vehiculos por color y año
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehicleByColorByYear(@PathVariable String color, @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.searchVehiclesByColorByYear(color, year), HttpStatus.OK);
    }

    //[US-0003] Buscar vehiculos por marcar y rango de años
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehicleByBradnByBeetweenYears(@PathVariable String brand, @PathVariable ("start_year") int startYear,
                                                                             @PathVariable("end_year") int endYear){
        return new ResponseEntity<>(vehicleService.searchVehiclesByBrandByBeetweenYears(brand,startYear,endYear), HttpStatus.OK);
    }

    //[US-0004] Consultar velocidad promedio por marca
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<AverageVehiclesDto> getAverageSpeedBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.calculateAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    //[US-0005] Añadir múltiples vehículos
    @PostMapping("/vehicles/batch")
    public ResponseEntity<ExceptionDto> addBatchVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.createBatchVehicles(vehicles);
    }

    //[US-0006] Actualizar velocidad máxima de un vehículo
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<ExceptionDto> putUpdateMaxSpeed(@PathVariable Long id, @RequestBody String updateSpeed){
        return vehicleService.updateMaxSpeed(id,updateSpeed);
    }

    //[US-0007]
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByFuelType(type),HttpStatus.OK);
    }


    //[US-0012] Buscar vehículos por dimensiones
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getVehicleByDimensions(@RequestParam("length") String lengthRange, @RequestParam("width") String widthRange) {
        return new ResponseEntity<>(vehicleService.searchVehiclesByDimensions(lengthRange,widthRange),HttpStatus.OK);
    }
}
