package com.mercadolibre.bootcamp.showroom.controller;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.MessageDTO;
import com.mercadolibre.bootcamp.showroom.dto.SaleDTO;
import com.mercadolibre.bootcamp.showroom.model.Sale;
import com.mercadolibre.bootcamp.showroom.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO createdSale = saleService.createSale(saleDTO);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        List<SaleDTO> sales = saleService.searchAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long number) {
        SaleDTO sale = saleService.searchSaleById(number);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<MessageDTO> updateSale(@PathVariable Long number, @RequestBody SaleDTO saleDetails) {
        MessageDTO messageDTO = saleService.updateSale(number, saleDetails);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<MessageDTO> deleteSale(@PathVariable Long number) {
        MessageDTO messageDTO = saleService.deleteSale(number);
        return new ResponseEntity<>(messageDTO, HttpStatus.NO_CONTENT);
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<GarmentDTO>> getGarmentDTOByDate(
            @RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        List<GarmentDTO> GarmentDTO = saleService.searchGarmentByDate(date);
        return new ResponseEntity<>(GarmentDTO, HttpStatus.OK);
    }


    @GetMapping("/garment/{number}")
    public ResponseEntity<List<GarmentDTO>> getGarmentDTOBySaleId(@PathVariable Long number) {
        List<GarmentDTO> GarmentDTO = saleService.searchGarmentBySaleId(number);
        return new ResponseEntity<>(GarmentDTO, HttpStatus.OK);
    }


}
