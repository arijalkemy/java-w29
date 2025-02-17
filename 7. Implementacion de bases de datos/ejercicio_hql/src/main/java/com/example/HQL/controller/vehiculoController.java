package com.example.HQL.controller;


import com.example.HQL.service.VehiculoService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class vehiculoController {

    private final VehiculoService vehiculoService;

    public vehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    //Listar las patentes de todos los vehículos registrados.
    @GetMapping("/vehiculos/patentes")
    public ResponseEntity<?> getListPatents() {
        return new ResponseEntity<>(vehiculoService.getListPatents(), HttpStatus.OK);
    }
}
