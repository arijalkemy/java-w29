package com.example.showroom.controller;

import com.example.showroom.model.dto.SaleDTO;
import com.example.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        return ResponseEntity.ok(saleService.createSale(saleDTO));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getSale() {
        return ResponseEntity.ok(saleService.getSales());
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> getSale(@PathVariable Long number) {
        return ResponseEntity.ok(saleService.getSale(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long number, @RequestBody SaleDTO saleDTO) {
        return ResponseEntity.ok(saleService.updateSale(saleDTO, number));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long number) {
        saleService.deleteSale(number);
        return ResponseEntity.noContent().build();
    }
}
