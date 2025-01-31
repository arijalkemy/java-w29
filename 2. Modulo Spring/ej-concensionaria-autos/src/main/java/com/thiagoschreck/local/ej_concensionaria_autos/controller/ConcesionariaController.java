package com.thiagoschreck.local.ej_concensionaria_autos.controller;

import com.thiagoschreck.local.ej_concensionaria_autos.dto.request.NewVehicleRequestDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.dto.response.NewVehicleResponseDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.dto.response.VehicleResponseDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.service.IConcesionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaController {

    private final IConcesionariaService service;

    @Autowired
    public ConcesionariaController(IConcesionariaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NewVehicleResponseDTO> addVehicle(@RequestBody NewVehicleRequestDTO request) {
        return ResponseEntity.ok(service.addVehicle(request));
    }
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getVehicles() {
        return ResponseEntity.ok(service.getVehicles());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesOrderedByDate(@RequestParam(value = "since", required = false) String since,
                                                                             @RequestParam(value = "to", required = false) String to) {
        return ResponseEntity.ok(service.getVehiclesByManufacturingDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesOrderedByPrice(@RequestParam(value = "since", required = false) String since,
                                                                              @RequestParam(value = "to", required = false) String to) {
        return ResponseEntity.ok(service.getVehiclesByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getVehicleById(id));
    }


}
