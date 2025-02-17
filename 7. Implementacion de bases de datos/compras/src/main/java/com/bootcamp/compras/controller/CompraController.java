package com.bootcamp.compras.controller;

import com.bootcamp.compras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private CompraService service;

    @Autowired
    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Comp>
}
