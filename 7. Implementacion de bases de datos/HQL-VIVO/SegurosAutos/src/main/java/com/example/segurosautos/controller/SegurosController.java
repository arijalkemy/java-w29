package com.example.segurosautos.controller;

import com.example.segurosautos.dto.response.MatriculaMarcaModeloVehiculoResponseDto;
import com.example.segurosautos.dto.response.PatenteMarcaVehiculoResponseDto;
import com.example.segurosautos.service.VehiculoServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/seguros")
@AllArgsConstructor
public class SegurosController {

    private final VehiculoServiceImp vehiculoServiceImp;


    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes(@RequestParam(required = false, defaultValue = "") String cantidadRuedasMax,
                                                    @RequestParam(required = false, defaultValue = "") String anioFabricacion) {
        return new ResponseEntity<>(vehiculoServiceImp.searchAllPatentes(cantidadRuedasMax, anioFabricacion), HttpStatus.OK);
    }

    @GetMapping("/pantentes-marca")
    public ResponseEntity<List<PatenteMarcaVehiculoResponseDto>> getPatenteMarcaVehiculo() {
        String order = "DESC";
        String by = "anioFabricacion";
        return new ResponseEntity<>(vehiculoServiceImp.searchAllPatentesAndMarca(order, by), HttpStatus.OK);
    }

    @GetMapping("/vehiculos-perdida-economica")
    public ResponseEntity<List<MatriculaMarcaModeloVehiculoResponseDto>> getVehiculosPerdidaEconomica() {
        Double perdidaEconomica = 1000.0;
        return new ResponseEntity<>(vehiculoServiceImp.searchVehicleByPerdidaEconomica(perdidaEconomica), HttpStatus.OK);
    }


}
