package com.mercadolibre.javawave29.concesionaria_de_autos.controller;

import com.mercadolibre.javawave29.concesionaria_de_autos.dto.ServiceVehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.dto.VehicleDTO;
import com.mercadolibre.javawave29.concesionaria_de_autos.exceptions.AddVehicleException;
import com.mercadolibre.javawave29.concesionaria_de_autos.exceptions.AddVehicleError;
import com.mercadolibre.javawave29.concesionaria_de_autos.exceptions.VehicleNotFoundException;
import com.mercadolibre.javawave29.concesionaria_de_autos.exceptions.VehicleNotFoundError;
import com.mercadolibre.javawave29.concesionaria_de_autos.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/vehicles")
public class CarDealerController {

    private final IService service;

    @Autowired
    public CarDealerController (IService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceVehicleDTO> addVehicle(@RequestBody ServiceVehicleDTO vehicle) {
        return service.addVehicle(vehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles () {
        return service.getVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceVehicleDTO> getVehicleById (@PathVariable Integer id) {
        return service.getVehicleById(id);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDates(@RequestParam(required = false) Integer since, @RequestParam(required = false) Integer to) {
        return service.getVehicleByDate(since, to);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDates(@RequestParam(required = false) Double since, @RequestParam(required = false) Double to) {
        return service.getVehicleByPrice(since, to);
    }

    @ExceptionHandler
    public ResponseEntity<VehicleNotFoundError> handleException (VehicleNotFoundException exc) {
        VehicleNotFoundError error = new VehicleNotFoundError(HttpStatus.NOT_FOUND.value(), exc.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler
    public ResponseEntity<AddVehicleError> handleException (AddVehicleException exc) {
        AddVehicleError error = new AddVehicleError(HttpStatus.BAD_REQUEST.value(), exc.getErrors());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
