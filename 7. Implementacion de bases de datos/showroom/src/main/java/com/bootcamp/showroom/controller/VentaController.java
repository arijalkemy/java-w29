package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.VentaDto;
import com.bootcamp.showroom.service.IVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class VentaController {
    private final IVentaService ventaService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody VentaDto ventaDto) {
        VentaDto venta = ventaService.save(ventaDto);
        return new ResponseEntity<>(venta, HttpStatus.CREATED);
    }
}
