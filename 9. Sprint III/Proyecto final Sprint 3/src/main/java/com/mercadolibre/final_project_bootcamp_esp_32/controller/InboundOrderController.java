package com.mercadolibre.final_project_bootcamp_esp_32.controller;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.InboundOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchDto;
import com.mercadolibre.final_project_bootcamp_esp_32.service.InboundOrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InboundOrderController {

    private final InboundOrderService inboundOrderService;

    public InboundOrderController(InboundOrderService inboundOrderService) {
        this.inboundOrderService = inboundOrderService;
    }

    //Requerimiento 1 - a
    @PostMapping("/api/v1/fresh-products/inboundorder")
    public ResponseEntity<List<ProductBatchDto>> postInboundOrderBatchStock(@Valid @RequestBody InboundOrderDto order, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(inboundOrderService.saveInboundOrderBatchStock(order,httpServletRequest), HttpStatus.CREATED);
    }

    //Requerimiento 1 - b
    @PutMapping("/api/v1/fresh-products/inboundorder")
    public ResponseEntity<List<ProductBatchDto>> putInboundOrderBatchStock(@Valid @RequestBody InboundOrderDto order) {
        return new ResponseEntity<>(inboundOrderService.modifyInboundOrderBatchStock(order), HttpStatus.CREATED);
    }

}
