package org.example.ej_compra.controller;

import lombok.RequiredArgsConstructor;
import org.example.ej_compra.dto.CompraDto;
import org.example.ej_compra.model.Cliente;
import org.example.ej_compra.service.ICompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
@RequiredArgsConstructor
public class CompraController {

    private final ICompraService service;


    @GetMapping
    public ResponseEntity<?> getAllCompras() {

        return new ResponseEntity<>(service.getAllCompras(), HttpStatus.OK);
    }

    @PostMapping("/addCompra/{clienteId}")
    public ResponseEntity<?> saveCompra(@PathVariable Long clienteId, @RequestBody CompraDto compraDto) {

        return new ResponseEntity<>(service.saveCompra(clienteId, compraDto), HttpStatus.OK);
    }


}
