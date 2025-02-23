package com.hqlvivo.hqlvivo.controller;

import com.hqlvivo.hqlvivo.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private IVehicleService service;

    @GetMapping("/vehiculos")
    public ResponseEntity<List<String>> getAllPatents() {
        return new ResponseEntity<>(service.getAllPatents(), HttpStatus.OK);
    }
}
