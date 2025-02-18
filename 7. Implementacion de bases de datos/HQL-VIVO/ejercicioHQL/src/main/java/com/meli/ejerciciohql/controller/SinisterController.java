package com.meli.ejerciciohql.controller;

import com.meli.ejerciciohql.model.Sinister;
import com.meli.ejerciciohql.model.Vehicle;
import com.meli.ejerciciohql.repository.IVehicleRepository;
import com.meli.ejerciciohql.service.ISinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sinister/")
public class SinisterController {
    @Autowired
    ISinisterService sinisterService;
    @Autowired
    IVehicleRepository vehicleRepository;

    @GetMapping("")
    public ResponseEntity<?> getSinisters(){

        return new ResponseEntity<>(sinisterService.getSinisters(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findSinister(@PathVariable Long id){

        return new ResponseEntity<>(sinisterService.findSinister(id), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> createSinister(@RequestBody Sinister sinister){

        Vehicle vehicle = vehicleRepository.findById(sinister.getVehicle().getId()).orElse(null);
        sinister.setVehicle(vehicle);
        sinisterService.saveSinister(sinister);
        return new ResponseEntity<>("Guardado",HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSinister(@PathVariable Long id){

        sinisterService.deleteSinister(id);
        return new ResponseEntity<>("Borrado", HttpStatus.OK);
    }

    @GetMapping("perdida")
    public ResponseEntity<?> getPerdida(){
        return new ResponseEntity<>(sinisterService.getSinisterPerdeidaMayor(),HttpStatus.OK);
    }
}
