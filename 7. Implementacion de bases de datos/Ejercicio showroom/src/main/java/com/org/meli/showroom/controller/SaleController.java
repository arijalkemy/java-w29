package com.org.meli.showroom.controller;

import com.org.meli.showroom.dto.GarmentDto;
import com.org.meli.showroom.dto.SaleDto;
import com.org.meli.showroom.exception.NotFoundException;
import com.org.meli.showroom.model.Sale;
import com.org.meli.showroom.repository.ISaleRepository;
import com.org.meli.showroom.service.ISaleService;
import com.org.meli.showroom.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/sale")
@AllArgsConstructor
public class SaleController {
    private final ISaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDto> postSale(@RequestBody SaleDto saleDto) {
        return new ResponseEntity<>(saleService.saveSale(saleDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSales() {
        return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDto> getSaleByNumber(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.getSaleByNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDto> updateSale(@PathVariable Long number, @RequestBody SaleDto saleDto) {
        return new ResponseEntity<>(saleService.updateSale(number, saleDto), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long number) {
        saleService.deleteSale(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/date")
    public ResponseEntity<List<SaleDto>> getSalesByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return new ResponseEntity<>(saleService.getSalesByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<GarmentDto>> getGarmentsBySaleNumber(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.getGarmentsBySaleNumber(number), HttpStatus.OK);
    }
}