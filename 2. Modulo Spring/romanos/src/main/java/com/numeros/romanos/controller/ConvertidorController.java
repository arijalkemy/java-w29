package com.numeros.romanos.controller;

import com.numeros.romanos.service.ConvertidorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("convertir")
public class ConvertidorController {

    private ConvertidorServiceImpl convertidorService;

    @Autowired
    public ConvertidorController(ConvertidorServiceImpl convertidorService) {
        this.convertidorService = convertidorService;
    }

    @GetMapping("/{numero}")
    public ResponseEntity<String> convertir(@PathVariable Integer numero) {
        return new ResponseEntity<>(convertidorService.convertir(numero), HttpStatus.OK);
    }
}
