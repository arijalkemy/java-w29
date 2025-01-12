package com.practicaspring.practicanumerosromanos.controller;

import com.practicaspring.practicanumerosromanos.services.ConvertirDecimalaRomano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/romanos")
public class ConversionARomanosController {
    @Autowired
    private ConvertirDecimalaRomano convertirDecimalaRomano;

    @GetMapping("/{numero}")
    public ResponseEntity<String> convertToRoman(@PathVariable int numero){
        String inputRomano = convertirDecimalaRomano.convertToRoman(numero);
        return ResponseEntity.ok(inputRomano);
    }
}
