package com.meli.deportistas.controller;

import com.meli.deportistas.model.DeporteModel;
import com.meli.deportistas.services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeporteController {
    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public List<DeporteModel> findSports() {
        return deporteService.getAllDeportes();
    }

    @GetMapping("/findSport/{name}")
    public Optional<DeporteModel> findSports(@PathVariable String name) {
        return deporteService.getDeporteByName(name);
    }
}
