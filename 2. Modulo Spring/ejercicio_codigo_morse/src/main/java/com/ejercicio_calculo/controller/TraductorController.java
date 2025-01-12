package com.ejercicio_calculo.controller;

import com.ejercicio_calculo.service.TraductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraductorController {

    @Autowired
    private TraductorService traductorService;

    @GetMapping
    public String traductor() {
        return "Ingresar texto en la URL";
    }

    @GetMapping("/{codigoMorse}")
    public String traductor(@PathVariable String codigoMorse) {
        return traductorService.traducir(codigoMorse);
    }


}
