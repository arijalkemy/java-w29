package com.mercadolibre.bootcamp.hqlvivo.controller;

import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteModeloMarcaDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPerdidaTotalDto;
import com.mercadolibre.bootcamp.hqlvivo.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<VehiculoPatenteDto>> getAllVehiculos() {
        return ResponseEntity.ok(vehiculoService.searchAll());
    }

    @GetMapping("/wheel-count-current-year")
    public ResponseEntity<List<VehiculoPatenteModeloMarcaDto>> getVehiculosByWheelCountAndCurrentYear() {
        return ResponseEntity.ok(vehiculoService.searchAllByWheelCountAndCurrentYear());
    }

    @GetMapping("/loss-over-10000")
    public ResponseEntity<List<VehiculoPatenteModeloMarcaDto>> getVehiculosByLossOver10000() {
        return ResponseEntity.ok(vehiculoService.searchAllByLossOver10000());
    }

    @GetMapping("/loss-over-10000-with-total")
    public ResponseEntity<VehiculoPerdidaTotalDto> getVehiculosByLossOver10000WithTotal() {
        return ResponseEntity.ok(vehiculoService.searchAllByLossOver10000WithTotal());
    }

}