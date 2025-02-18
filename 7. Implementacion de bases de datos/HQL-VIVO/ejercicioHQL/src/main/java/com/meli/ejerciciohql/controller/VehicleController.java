package com.meli.ejerciciohql.controller;

import com.meli.ejerciciohql.model.Vehicle;
import com.meli.ejerciciohql.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @GetMapping("")
    public ResponseEntity<?> getVehicles(){

        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findVehicle(@PathVariable Long id){

        return new ResponseEntity<>(vehicleService.findVehicle(id), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle){

        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>("Guardado",HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){

        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>("Borrado", HttpStatus.OK);
    }

    @GetMapping("/patente")
    public ResponseEntity <?> getPatentes(){

        return new ResponseEntity<>(vehicleService.getPatentes(),HttpStatus.OK);
    }
    @GetMapping("/patente/anio")
    public ResponseEntity <?> getPatentesAnio(){

        return new ResponseEntity<>(vehicleService.getPatentesAnio(),HttpStatus.OK);
    }
}
