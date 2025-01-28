package com.concesionariaautos.ejercicioconcesionaria.controller;

import com.concesionariaautos.ejercicioconcesionaria.dto.request.VehicleRequestDto;
import com.concesionariaautos.ejercicioconcesionaria.dto.response.VehicleResponseDto;
import com.concesionariaautos.ejercicioconcesionaria.service.IVehicleService;
import com.concesionariaautos.ejercicioconcesionaria.service.VehicleServiceImple;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController{

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImple vehicleService){
        this.vehicleService = vehicleService;
    }

    //endpoint para guardar vehiculo
    @PostMapping()
    public ResponseEntity<VehicleResponseDto> postSaveVehicle(@RequestBody VehicleRequestDto vehicleRequestDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleRequestDto), HttpStatus.CREATED);
    }

    //endpoint para retornar listado de vehiculos
    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> getListVehicles(){
        return new ResponseEntity<>(vehicleService.findListVehicles(), HttpStatus.OK);
    }

    //endpoint para retornar listado de vehiculos segun fecha de fabricación
    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDto>> getListVehiclesForDateBuild(
            @RequestParam String since, @RequestParam String to)
    {
        return new ResponseEntity<>(vehicleService.findListVehiclesForDateBuild(since, to), HttpStatus.OK);
    }

    //endpoint para retornar listado de vehiculos segun fecha los precios
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDto>> getListVehiclesForPrices(
            @RequestParam String since, @RequestParam String to)
    {
        return new ResponseEntity<>(vehicleService.findListVehiclesForForPrices(since, to), HttpStatus.OK);
    }

    //endpoint para retornar vehiculo por id
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getListVehiclesForPrices(
            @PathVariable Long id)
    {
        return new ResponseEntity<>(vehicleService.findVehicle(id), HttpStatus.OK);
    }
}
