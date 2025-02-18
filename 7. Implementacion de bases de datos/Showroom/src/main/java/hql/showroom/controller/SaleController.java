package hql.showroom.controller;

import hql.showroom.dto.request.SaleRequestDTO;
import hql.showroom.dto.response.SaleResponseDTO;
import hql.showroom.model.Clothing;
import hql.showroom.model.Sale;
import hql.showroom.service.SaleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleServiceImpl saleService;

    public SaleController(SaleServiceImpl saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> createSale(@RequestBody SaleRequestDTO saleRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(saleRequestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sale>> getAllSalesWithClothing() {
        return ResponseEntity.ok(saleService.getAllSalesWithClothing());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Sale>> getSalesByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(saleService.getSalesByDate(date));
    }

    @GetMapping("/payment/{paymentMethod}")
    public ResponseEntity<List<Sale>> getSalesByPaymentMethod(@PathVariable String paymentMethod) {
        return ResponseEntity.ok(saleService.getSalesByPaymentMethod(paymentMethod));
    }

    @GetMapping("/clothing-sold")
    public ResponseEntity<List<Clothing>> getClothingSoldBetweenDates(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(saleService.getClothingSoldBetweenDates(startDate, endDate));
    }
}
