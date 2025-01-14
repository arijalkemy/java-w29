package com.ejercicio.numerosromanos.Controllers;

import com.ejercicio.numerosromanos.Services.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @GetMapping("/Convert/{number}")
    public String Convert(@PathVariable String number) {
        Integer numberInt = convertService.convertRomanNumber(number);
        if (numberInt != -1) {
            return "El número es " + numberInt;
        }
        return "El número no es válido";
    }
}
