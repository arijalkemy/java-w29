package com.mercadolibre.final_project_bootcamp_esp_32.controller;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductWarehouseResponseDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ResponseProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.service.IProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/")
@Validated
public class ProductController {

    @Autowired
    IProductService productService;

    //Requerimiento 2 - a y b
    @GetMapping("/list")
    ResponseEntity<ResponseProductDTO> getProducts(
            @RequestParam(required = false)
            @Pattern(regexp = "^(FF|FS|RF|ALL)?$", message = "La categoría debe ser 'FF', 'FS', 'RF' o 'ALL'.")
            String category) {
        return ResponseEntity.ok(productService.selectMethod(category));
    }

   //Requerimiento 4
    @GetMapping("/{idProduct}/warehouse/list")
    ResponseEntity<ProductWarehouseResponseDto> getProductsByWarehouse(@PathVariable @Positive(message = "El product id debe ser mayor a 0") Integer idProduct, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(productService.searchProductsByWarehouse(idProduct, httpServletRequest));
    }
}
