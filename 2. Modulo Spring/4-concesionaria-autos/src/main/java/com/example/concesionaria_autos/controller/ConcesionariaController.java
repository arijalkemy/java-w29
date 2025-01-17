package com.example.concesionaria_autos.controller;

import com.example.concesionaria_autos.dto.request.VehiculoDTO;
import com.example.concesionaria_autos.dto.response.VehiculoResponseDTO;
import com.example.concesionaria_autos.dto.response.VehiculoWServicesDTO;
import com.example.concesionaria_autos.entity.Vehiculo;
import com.example.concesionaria_autos.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class ConcesionariaController {

    private final IVehiculoService iVehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoResponseDTO> agregarVehiculo(@RequestBody VehiculoDTO vehiculo){
        return new ResponseEntity<>(this.iVehiculoService.agregarVehiculo(vehiculo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehiculoWServicesDTO>> getVehicles(){
        return new ResponseEntity<>(this.iVehiculoService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehiculoWServicesDTO>> getVehiclesByYearRange(
            @RequestParam String since,
            @RequestParam String to
    ){
        return new ResponseEntity<>(this.iVehiculoService.searchVehiclesByYearRange(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiculoWServicesDTO>> getVehiclesBypriceRange(
            @RequestParam String since,
            @RequestParam String to
    ){
        return new ResponseEntity<>(this.iVehiculoService.searchVehiclesBypriceRange(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoWServicesDTO> getVehiclesById(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(this.iVehiculoService.searchVehicleById(id), HttpStatus.OK);
    }
}
