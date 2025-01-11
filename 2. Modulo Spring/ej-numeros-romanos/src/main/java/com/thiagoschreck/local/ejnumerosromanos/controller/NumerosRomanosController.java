package com.thiagoschreck.local.ejnumerosromanos.controller;

import com.thiagoschreck.local.ejnumerosromanos.dto.NumeroRomanoDTO;
import com.thiagoschreck.local.ejnumerosromanos.service.NumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/romanos")
public class NumerosRomanosController {

    @Autowired
    private NumerosRomanosService numerosRomanosService;

    @GetMapping("/convertir/{numero}")
    public ResponseEntity<NumeroRomanoDTO> convertirANumerosRomanos(@PathVariable String numero) {
        try {
            return ResponseEntity.ok(numerosRomanosService.convertirANumeroRomano(Integer.parseInt(numero)));
        } catch (NumberFormatException ex) {
            return ResponseEntity.ok(numerosRomanosService.convertirANumeroEntero(numero));
        }
    }
}
