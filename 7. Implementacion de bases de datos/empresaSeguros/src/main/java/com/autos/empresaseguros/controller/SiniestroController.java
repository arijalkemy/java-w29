package com.autos.empresaseguros.controller;

import com.autos.empresaseguros.dto.PerdidaEconomicaInfoProjection;
import com.autos.empresaseguros.dto.PerdidaEconomicaProjection;
import com.autos.empresaseguros.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiniestroController {
    @Autowired
    public ISiniestroService siniestroService;

    @GetMapping("/siniestros-mayor-10000")
    public ResponseEntity<List<PerdidaEconomicaProjection>> getSiniestrosMayores(){
        return new ResponseEntity<>(siniestroService.getSiniestrosMayores(), HttpStatus.OK);
    }

    @GetMapping("/info-siniestros-mayor-10000")
    public ResponseEntity<List<PerdidaEconomicaInfoProjection>> getInfoSiniestrosMayores(){
        return new ResponseEntity<>(siniestroService.getInfoSiniestrosMayores(), HttpStatus.OK);
    }
}
