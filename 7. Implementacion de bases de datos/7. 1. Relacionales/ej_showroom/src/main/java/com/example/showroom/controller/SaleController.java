package com.example.showroom.controller;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.dto.SaleDto;
import com.example.showroom.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDto>> getSales(
            @RequestParam(required = false) @DateTimeFormat LocalDate date) {
        return ResponseEntity.ok(saleService.getSales(date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> getSaleById(@PathVariable Integer id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PostMapping
    public ResponseEntity<String> createSale(@RequestBody SaleDto saleDto) {
        saleService.createSale(saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(saleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClotheDto>> getSalesByClotheNumber(@PathVariable Integer number) {
        return ResponseEntity.ok(saleService.getClothesBySale(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDto> updateSale(@PathVariable Integer number, @RequestBody SaleDto saleDto) {
        return ResponseEntity.ok(saleService.updateSale(number, saleDto));
    }
}
