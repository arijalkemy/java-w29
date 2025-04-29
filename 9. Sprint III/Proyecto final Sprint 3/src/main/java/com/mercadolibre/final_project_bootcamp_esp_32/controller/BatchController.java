package com.mercadolibre.final_project_bootcamp_esp_32.controller;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.BatchStockDueDateDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.service.IBatchService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
public class BatchController {

    private final IBatchService batchService;

    //Requerimiento 3
    @GetMapping("/api/v1/fresh-products/{productId}/batch/list")
    public ResponseEntity<ProductBatchStockDto> getFreshProduct(@PathVariable @Positive(message = "El product id debe ser mayor a 0") Integer productId,
                                                                @RequestParam(required = false)
                                                                    @Pattern(regexp = "^(L|C|F)?$", message = "El valor del order debe ser 'L', 'C' o 'F'.")
                                                                    String order, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(batchService.searchFreshProducts(productId, order, httpServletRequest), HttpStatus.OK);
    }

    //Requerimiento 5
    @GetMapping("/api/v1/fresh-products/batch/list/due-date/{cantDays}")
    public ResponseEntity<BatchStockDueDateDTO> getBatchesByDueDate(@PathVariable @Positive(message = "La cantidad de dias debe ser mayor a 0") Integer cantDays,
                                                                    @RequestParam(required = false, defaultValue = "date_asc")
                                                                    @Pattern(regexp = "^(date_asc|date_desc)?$", message = "El valor del order debe ser 'date_asc' o 'date_desc'.")
                                                                            String order,
                                                                    @RequestParam(required = false, defaultValue = "ALL")
                                                                    @Pattern(regexp = "^(FF|FS|RF|ALL)?$", message = "El valor del order debe ser 'FF', 'FS' o 'RF'.")
                                                                    String category,
                                                                    HttpServletRequest httpServletRequest){
        return new ResponseEntity<>(batchService.getBatchStock(cantDays, httpServletRequest, order, category), HttpStatus.OK);
    }

}
