package org.example.ej_compra.controller;

import lombok.RequiredArgsConstructor;
import org.example.ej_compra.dto.ClienteDto;
import org.example.ej_compra.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService service;

    @PostMapping("/addCliente")
    public ResponseEntity<?> addCliente(@RequestBody ClienteDto clienteDto) {

        return new ResponseEntity<>(service.saveCliente(clienteDto), HttpStatus.OK);
    }

    @GetMapping("/getClients")
    public ResponseEntity<?> getAllClientes() {

        return new ResponseEntity<>(service.getAllClientes(), HttpStatus.OK);
    }
}
