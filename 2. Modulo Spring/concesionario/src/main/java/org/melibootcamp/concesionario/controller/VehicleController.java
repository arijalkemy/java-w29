package org.melibootcamp.concesionario.controller;

import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.melibootcamp.concesionario.dto.request.VehicleRequestDto;
import org.melibootcamp.concesionario.dto.response.VehicleResponseDTO;
import org.melibootcamp.concesionario.dto.response.VehicleResponseUsedDto;
import org.melibootcamp.concesionario.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleServiceImpl vehicleService;

    @PostMapping()
    public ResponseEntity<VehicleResponseDTO> createVehicle(@RequestBody VehicleRequestDto vehicleRequestDto){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleRequestDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<VehicleResponseUsedDto>> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(),HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<VehicleResponseUsedDto>> getVehiclesByDate(@RequestParam LocalDate since,@RequestParam LocalDate to){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByDate(since,to),HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseUsedDto>> getVehiclesByPrices(@RequestParam Double since,@RequestParam Double to){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByPrices(since,to),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehiclesByID(@PathVariable Integer id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id),HttpStatus.OK);
    }
}
