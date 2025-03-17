package com.example.insurance.controller;

import com.example.insurance.dto.VehicleDTO;
import com.example.insurance.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/insurance")
@Validated
public class InsuranceController {
    @Autowired
    private IVehicleService service;

    /* Listar las patentes de todos los vehículos registrados. */
    @GetMapping("/patents")
    public ResponseEntity<List<VehicleDTO>> getPatentsRegistered() {
        return ResponseEntity.ok(service.searchAllPatentsRegistered());
    }

    /* Listar la patente y la marca de todos los vehículos ordenados por año de fabricación. */

    @GetMapping("/patents-brand-order-by-year")
    public ResponseEntity<List<VehicleDTO>> getPatentsAndBrandOrderByYear() {
        return ResponseEntity.ok(service.searchAllPatentsAndBrandOrderByYear());
    }

    /* Listar la patente de todos los vehículos que tengan más de cuatro ruedas y
     hayan sido fabricados en el corriente año.*/
    @GetMapping("/above-4-wheels-current-year")
    public ResponseEntity<List<VehicleDTO>> getPatentsAbove4WheelsCurrentYear() {
        return ResponseEntity.ok(service.searchPatentsAbove4WheelsCurrentYear());
    }

    /*
    Listar la matrícula, marca y modelo
    de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
     */

    @GetMapping("/lost-above-10000")
    public ResponseEntity<List<VehicleDTO>> getVehicleWithLostAbove10000() {
        return ResponseEntity.ok(service.searchVehicleWithLostAbove10000());
    }

    /* matrícula, marca, modelo, perdida > 10000 y mostrar la perdida total de todos ellos */

    @GetMapping("/lost-above-10000-with-total")
    public ResponseEntity<List<VehicleDTO>> getVehicleWithLostAbove10000WithTotal() {
        return ResponseEntity.ok(service.getVehicleWithLostAbove10000WithTotal());
    }
}
