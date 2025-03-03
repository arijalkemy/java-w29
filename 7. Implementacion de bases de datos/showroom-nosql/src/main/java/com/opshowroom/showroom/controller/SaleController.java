package com.opshowroom.showroom.controller;

import com.opshowroom.showroom.domain.Clothe;
import com.opshowroom.showroom.domain.Sale;
import com.opshowroom.showroom.dto.request.ClotheDTO;
import com.opshowroom.showroom.dto.request.SaleDTO;
import com.opshowroom.showroom.dto.response.ResponseDTO;
import com.opshowroom.showroom.dto.response.SaleResDTO;
import com.opshowroom.showroom.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService saleService;

    @Autowired
    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createSale(@RequestBody SaleDTO saleDTO) {
        SaleResDTO sale = saleService.createSale(saleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO<>(sale, "Sale created successfully"));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllSales() {
        Iterable<Sale> sales = saleService.getAllSales();
        return ResponseEntity.ok(new ResponseDTO<>(sales, "Sales retrieved successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getSaleById(@PathVariable Long id) {
        SaleResDTO sale = saleService.getSaleById(id);
        return ResponseEntity.ok(new ResponseDTO<>(sale, "Sale retrieved successfully"));
    }

    @PutMapping("/{number}")
    public ResponseEntity<ResponseDTO> updateSale(@PathVariable Long number, @RequestBody SaleDTO sale) {
        SaleResDTO updatedSale = saleService.updateSale(number, sale);
        return ResponseEntity.ok(new ResponseDTO<>(updatedSale, "Sale updated successfully"));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Long number) {
        saleService.deleteSale(number);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(params = "date")
    public ResponseEntity<ResponseDTO> getSalesByDate(@RequestParam("date") String dateStr) {
        List<SaleResDTO> sales = saleService.getSalesByDate(dateStr);
        return ResponseEntity.ok(new ResponseDTO<>(sales, "Sales retrieved successfully"));
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<ResponseDTO> getClothesBySale(@PathVariable Long number) {
        List<Clothe> clothesList = saleService.getClothesBySale(number);
        return ResponseEntity.ok(new ResponseDTO<>(clothesList, "Clothes retrieved successfully"));
    }
}