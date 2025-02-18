package com.autos.empresaseguros.controller;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.model.Vehiculo;
import com.autos.empresaseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    public IVehiculoService vehiculoService;

    @GetMapping("/all")
    public ResponseEntity<List<VehiculoDTO>> getAllVehicles(){
        return new ResponseEntity<>(vehiculoService.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("/patents")
    public ResponseEntity<List<VehiculoDTO>> getPatentes(){
        return new ResponseEntity<>(vehiculoService.searchPatentes(), HttpStatus.OK);
    }
}
