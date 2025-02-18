package com.bootcamp.ropita_extra.controller;

import com.bootcamp.ropita_extra.dto.ClothesDto;
import com.bootcamp.ropita_extra.dto.SaleRequestDto;
import com.bootcamp.ropita_extra.dto.SaleResponseDto;
import com.bootcamp.ropita_extra.service.ISalesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SalesController {
    private final ISalesService service;

    @Autowired
    public SalesController(ISalesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getAllSales(){
        return ResponseEntity.ok(service.findAllSales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDto> getSaleById(@PathVariable String id){
        return ResponseEntity.ok(service.findSaleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaleById(@PathVariable String id){
        service.deleteSaleById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<SaleResponseDto> createSale(@Valid @RequestBody SaleRequestDto saleRequestDto){
        return ResponseEntity.ok(service.saveSale(saleRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDto> updateSale(@PathVariable String id, @Valid @RequestBody SaleRequestDto saleRequestDto){
        return ResponseEntity.ok(service.updateSale(id, saleRequestDto));
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<ClothesDto>> getClothesFromSale(@PathVariable String id){
        return ResponseEntity.ok(service.findClothesFromSale(id));
    }
}
