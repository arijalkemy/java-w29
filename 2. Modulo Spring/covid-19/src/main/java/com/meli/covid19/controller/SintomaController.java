package com.meli.covid19.controller;

import com.meli.covid19.model.SintomaModel;
import com.meli.covid19.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {
    private final SintomaService sintomaService;
    @Autowired
    public SintomaController(SintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }

    @GetMapping("/findSymptom")
    public List<SintomaModel> findSymptom() {
        return sintomaService.getSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public SintomaModel findSymptomByName(@PathVariable String name) {
        return sintomaService.getSintomaByName(name);
    }
}
