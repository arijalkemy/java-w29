package com.autos.empresaseguros.controller;

import com.autos.empresaseguros.dto.PatenteAndMarcaDTO;
import com.autos.empresaseguros.dto.PatenteDTO;
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

    @GetMapping("/patentes")
    public ResponseEntity<List<PatenteDTO>> getAllPatentes(){
        return new ResponseEntity<>(vehiculoService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentes-marcas")
    public ResponseEntity<List<PatenteAndMarcaDTO>> getPatenteAndMarcaOrderedByYear(){
        return new ResponseEntity<>(vehiculoService.getPatenteAndMarcaOrderedByYear(), HttpStatus.OK);
    }

    @GetMapping("/vehiculos-mas-4-ruedas")
    public ResponseEntity<List<PatenteDTO>> getPatenteVehiculosConMas4Ruedas(){
        return new ResponseEntity<>(vehiculoService.getPatenteVehiculosConMas4Ruedas(), HttpStatus.OK);
    }
}
