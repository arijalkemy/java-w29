package com.bootcamp.ej_numeros_romanos.controller;

import com.bootcamp.ej_numeros_romanos.model.NumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numeros-romanos")
public class NumerosRomanosController {

    @Autowired
    private NumerosRomanosService numerosRomanosService;

    @GetMapping("/{numero}")
    public String getNumeroEnRomanos(@PathVariable("numero") Integer numero) {
        return numerosRomanosService.convertFromInteger(numero);
    }
}