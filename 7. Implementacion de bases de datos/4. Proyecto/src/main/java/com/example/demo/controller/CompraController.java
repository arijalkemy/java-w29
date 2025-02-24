package com.example.demo.controller;

import com.example.demo.dto.CompraDTO;
import com.example.demo.service.ICompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("compras")
public class CompraController {
    private final ICompraService iCompraService;

    @PostMapping("/nueva")
    ResponseEntity<?> nuevaCompra(@RequestBody CompraDTO compra) {
        return new ResponseEntity<>(iCompraService.nuevaCompra(compra), HttpStatus.OK);
    }
}
