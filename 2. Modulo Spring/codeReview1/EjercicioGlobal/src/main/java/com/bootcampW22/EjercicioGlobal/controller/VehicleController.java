package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.FuelTypeDTO;
import com.bootcampW22.EjercicioGlobal.dto.MaxSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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

    //1- Añadir vehiculo
    @PostMapping("/vehicles")
    public ResponseEntity<?> addNewVehicle (@RequestBody VehicleDto v){
        vehicleService.saveVehicle(v);
        return new ResponseEntity<>("Vehículo creado exitosamente.",HttpStatus.CREATED);
    }

    //2-Buscar un vehiculo por color y año
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehicleBYcolorYear(@PathVariable String color,@PathVariable int year){
        return new ResponseEntity<>( vehicleService.serchByColorAndYear(color,year),HttpStatus.OK);
    }

    //3-Buscar vehiculos por marca y rango de años
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> getVehicleByBrandRangeYear(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year ){
        return  new ResponseEntity<>(vehicleService.serchByBrandAndRangeYear(brand,start_year,end_year),HttpStatus.OK);
    }

    //4-Consultar velocidad promedio por marca
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable  String brand){
        return new ResponseEntity<>(vehicleService.getAverageSpeedByBrand(brand),HttpStatus.OK);
    }

    //5-Añadir multiple vehiculos
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addNewMultVehicles(@RequestBody List<VehicleDto> listVehicles){
        vehicleService.saveMultVehicles(listVehicles);
        return new ResponseEntity<>("Vehículos creados exitosamente.",HttpStatus.OK);
    }

    //6- Actualizar velocidad máxima de un vehículo
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeedVehicle (@PathVariable Long id, @RequestBody MaxSpeedDTO msDTO){
        vehicleService.updateVehicleSpeed(id,msDTO);
        return new ResponseEntity<>("Velocidad del vehículo actualizada exitosamente.",HttpStatus.OK);
    }

    //7-Listar vehículos por tipo de combustible
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> getVehicleByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.serchByFuelType(type),HttpStatus.OK);
    }

    //8-Eliminar un vehículo
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        vehicleService.deletevehicle(id);
        return new ResponseEntity<>("Vehículo eliminado exitosamente.",HttpStatus.NO_CONTENT);
    }

    //9-Buscar vehículos por tipo de transmisión
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> getVehicleByTransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.searchByTransmission(type),HttpStatus.OK);
    }

    //10-Actualizar el tipo de combustible de un vehículo
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuelTypeViehicle(@PathVariable Long id, @RequestBody FuelTypeDTO ftDTO){
        vehicleService.updateFuelType(id,ftDTO);
        return new ResponseEntity<>("Tipo de combustible del vehículo actualizado exitosamente.", HttpStatus.OK);
    }

    //11-Obtener la capacidad promedio de personas por marca
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAveragePassengers(@PathVariable String brand){
        return  new ResponseEntity<>(vehicleService.getAveragePassengers(brand),HttpStatus.OK);
    }

    //12-Buscar vehículos por dimensiones
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByDimesions(@RequestParam ("length") String lengthRange, @RequestParam ("width") String widthRange){
        return new ResponseEntity<>(vehicleService.serchVehiclesByDimensions(lengthRange,widthRange),HttpStatus.OK);
    }

    //13-Listar vehículos por rango de peso
    @GetMapping("vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeight(@RequestParam ("min") String minWeight , @RequestParam("max") String maxWeight){
        return  new ResponseEntity<>(vehicleService.serchVehiclesByWeight(minWeight,maxWeight),HttpStatus.OK);
    }


}
