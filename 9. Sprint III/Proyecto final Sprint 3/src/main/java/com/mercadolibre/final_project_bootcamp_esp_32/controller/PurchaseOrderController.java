package com.mercadolibre.final_project_bootcamp_esp_32.controller;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.PurchaseOrderRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductsPurchaseOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.PurchaseOrderResponseDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.PurchasedProductsByDateRangeDto;
import com.mercadolibre.final_project_bootcamp_esp_32.service.IPurchaseOrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products")
@Validated
public class PurchaseOrderController {

    private final IPurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(IPurchaseOrderService purchaseOrderService) { this.purchaseOrderService = purchaseOrderService; }

    //Requerimiento 2
    @PostMapping("/orders")
    public ResponseEntity<PurchaseOrderResponseDto> createPurchaseOrder(@RequestBody PurchaseOrderRequestDto order){
        PurchaseOrderResponseDto response = purchaseOrderService.createPurchaseOrder(order);
        if (response.getTotalPrice() > 0.0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //Requerimiento 2
    @GetMapping("/orders/{idOrder}")
    ResponseEntity<ProductsPurchaseOrderDto> getProductsByOrder(@PathVariable @Positive(message = "El order id debe ser mayor a 0") Integer idOrder) {
        return ResponseEntity.ok(purchaseOrderService.listProductsByPurchaseOrder(idOrder));
    }

    //Requerimiento 2
    @PutMapping("/orders/{idOrder}")
    public ResponseEntity<PurchaseOrderResponseDto> updatePurchaseOrder(@PathVariable @Positive(message = "El order id debe ser mayor a 0") Integer idOrder, @RequestBody PurchaseOrderRequestDto updatedOrder) {
        PurchaseOrderResponseDto response = purchaseOrderService.updatePurchaseOrder(idOrder, updatedOrder);

        return ResponseEntity.ok(response);
    }

    //Requerimiento 6
    @GetMapping("/statistics")
    ResponseEntity<PurchasedProductsByDateRangeDto> getPurchasedProductsByDateRange(HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(purchaseOrderService.searchPurchasedProductsByDateRange(httpServletRequest));
    }

}
