package com.example.demo.controler;

import com.example.demo.service.CovidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidController {

    @Autowired
    CovidServiceImpl service;

    @GetMapping("/findSymptom")
    public ResponseEntity<?> findAllSintomas(){
        return ResponseEntity.ok(service.serchSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSintomaByName(@PathVariable String name){
        return ResponseEntity.ok(service.serchByName(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findPersonaRiesgo(){
        return ResponseEntity.ok(service.serchPersonasRiesgo());
    }
}
