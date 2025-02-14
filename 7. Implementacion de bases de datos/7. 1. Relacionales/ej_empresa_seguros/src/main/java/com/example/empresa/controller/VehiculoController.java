package com.example.empresa.controller;

import com.example.empresa.dto.PatenteAndMarcaDto;
import com.example.empresa.dto.PatenteMarcaModeloDto;
import com.example.empresa.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@Validated
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes() {
        return ResponseEntity.ok(vehiculoService.getPatentes());
    }

    @GetMapping("/patentes-and-marcas")
    public ResponseEntity<List<PatenteAndMarcaDto>> getPatentesAndMarcas() {
        return ResponseEntity.ok(vehiculoService.getPatentesAndMarcas());
    }

    @GetMapping("/cuatro-ruedas-and-current-year")
    public ResponseEntity<List<String>> getVehiculosCuatroRuedasAndCurrentYear() {
        return ResponseEntity.ok(vehiculoService.getVehiculosCuatroRuedasAndCurrentYear());
    }

    @GetMapping("/siniestro-mayor-a-10000")
    public ResponseEntity<List<PatenteMarcaModeloDto>> getVehiculosConSiniestroMayorA10000() {
        return ResponseEntity.ok(vehiculoService.getVehiculosConSiniestroMayorA10000());
    }
}
