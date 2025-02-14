package com.example.compras.controller;

import com.example.compras.dto.request.ClienteRequestDto;
import com.example.compras.dto.response.ClienteResponseDto;
import com.example.compras.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getClientes() {
        return ResponseEntity.ok(service.getClientes());
    }

    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody ClienteRequestDto clienteDto) {
        service.saveCliente(clienteDto);
        return ResponseEntity.ok("Cliente creado");
    }
}
