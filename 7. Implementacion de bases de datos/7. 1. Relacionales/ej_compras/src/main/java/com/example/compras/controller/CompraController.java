package com.example.compras.controller;

import com.example.compras.dto.request.CompraRequestDto;
import com.example.compras.dto.response.CompraResponseDto;
import com.example.compras.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService service;

    @GetMapping
    public ResponseEntity<List<CompraResponseDto>> getCompras() {
        return ResponseEntity.ok(service.getCompras());
    }

    @PostMapping("/{clienteId}")
    public ResponseEntity<String> saveCompra(
            @PathVariable Long clienteId,
            @RequestBody CompraRequestDto compraDto) {
        service.saveCompra(clienteId, compraDto);
        return ResponseEntity.ok("Compra creada");
    }

    @GetMapping("/cliente/{clienteId}/fecha/{fecha}")
    public ResponseEntity<CompraResponseDto> getCompra(
            @PathVariable Long clienteId,
            @PathVariable LocalDate fecha) {
        return ResponseEntity.ok(service.getCompra(clienteId, fecha));
    }
}
