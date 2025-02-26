package com.autos.empresaseguros.controller;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    public IVehiculoService vehiculoService;

    @GetMapping("/all")
    public ResponseEntity<List<VehiculoDTO>> getAllVehicles(){
        return new ResponseEntity<>(vehiculoService.getAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public void saveVehicle(@RequestBody VehiculoDTO vehiculoDTO){
        vehiculoService.saveVehicle(vehiculoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long id){
        vehiculoService.deleteVehicle(id);
    }

    @GetMapping("/{id}")
    public VehiculoDTO getVehicById(@PathVariable Long id){
        return vehiculoService.findVehicleById(id);
    }
}
