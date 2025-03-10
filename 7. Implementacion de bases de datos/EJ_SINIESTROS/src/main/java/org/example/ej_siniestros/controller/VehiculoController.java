package org.example.ej_siniestros.controller;

import lombok.RequiredArgsConstructor;
import org.example.ej_siniestros.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehiculo")
public class VehiculoController {

    private final IVehiculoService service;


    @GetMapping
    public ResponseEntity<?> getAllPatentes() {

        return new ResponseEntity<>(service.getallPatentes(), HttpStatus.OK);
    }

    @GetMapping("/getVehiculoByYear")
    public ResponseEntity<?> getAllVehiculosByOrderYear() {

        return new ResponseEntity<>(service.getAllPatentesAndBrandByAnio(), HttpStatus.OK);
    }

    @GetMapping("/getVehiculoGreaterThan1000")
    public ResponseEntity<?> findVehiclesWithAccidentEconomicLossGreaterThan10000() {

        return new ResponseEntity<>(service.findVehiclesWithAccidentEconomicLossGreaterThan10000(), HttpStatus.OK);
    }


}
