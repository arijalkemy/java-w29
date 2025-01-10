package com.meli.numerosromanos.controller;

import com.meli.numerosromanos.service.NumeroRomanoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {

    NumeroRomanoService numeroRomanoService;

    public NumeroRomanoController() {
        numeroRomanoService = new NumeroRomanoService();
    }

    @GetMapping("/{numero}")
    public String numeroRomano(@PathVariable("numero") Integer numero) {
        return numeroRomanoService.integerToRomano(numero);
    }
}
