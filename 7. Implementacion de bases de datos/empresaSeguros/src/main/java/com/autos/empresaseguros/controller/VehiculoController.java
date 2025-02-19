package com.autos.empresaseguros.controller;

import com.autos.empresaseguros.dto.VehiculoDTO;
import com.autos.empresaseguros.dto.VehiculoSiniestroDto;
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
    public ResponseEntity<List<VehiculoDTO>> getPatents(){
        return new ResponseEntity<>(vehiculoService.searchPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patents-and-brand")
    public ResponseEntity<List<VehiculoDTO>> getPatentsAndBrandForYear(){
        return new ResponseEntity<>(vehiculoService.searchPatentsAndBrandForYear(), HttpStatus.OK);
    }

    @GetMapping("/patents-with-wheels")
    public ResponseEntity<List<VehiculoDTO>> getPatentsWithWheels(){
        return new ResponseEntity<>(vehiculoService.searchPatentsWithWheels(), HttpStatus.OK);
    }

    @GetMapping("/vehicles-with-loss")
    public ResponseEntity<List<VehiculoDTO>> getVehiclesWithLoss(){
        return new ResponseEntity<>(vehiculoService.searchVehiclesWithLoss(), HttpStatus.OK);
    }

    @GetMapping("/siniestros/vehicles-with-loss")
    public ResponseEntity<List<VehiculoSiniestroDto>> getSiniestrosVehiclesWithLoss(){
        return new ResponseEntity<>(vehiculoService.searchiniestrosVehiclesWithLoss(), HttpStatus.OK);
    }
}
