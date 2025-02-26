package com.opshowroom.showroom.controller;

import com.opshowroom.showroom.domain.Sale;
import com.opshowroom.showroom.dto.ClotheDTO;
import com.opshowroom.showroom.dto.SaleDTO;
import com.opshowroom.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody Sale sale) {
        Sale createdSale = saleService.createSale(sale);
        return ResponseEntity.ok(createdSale);
    }

    @GetMapping
    public ResponseEntity<?> getAllSales() {
        List<SaleDTO> sales = saleService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getSaleByNumber(@PathVariable Long number) {
        SaleDTO sale = saleService.getSaleByNumber(number);
        return ResponseEntity.ok(sale);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@PathVariable Long number, @RequestBody Sale sale) {
        Sale updatedSale = saleService.updateSale(number, sale);
        return ResponseEntity.ok(updatedSale);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Long number) {
        saleService.deleteSale(number);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = "date")
    public ResponseEntity<?> getSalesByDate(@RequestParam("date") String dateStr) {
        List<SaleDTO> sales = saleService.getSalesByDate(dateStr);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getClothesBySale(@PathVariable Long number ) {
        List<ClotheDTO> clothesList = saleService.getClothesBySale(number);
        return ResponseEntity.ok(clothesList);
    }
}