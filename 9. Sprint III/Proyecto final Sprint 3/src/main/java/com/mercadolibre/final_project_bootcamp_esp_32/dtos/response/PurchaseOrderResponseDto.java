package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseOrderResponseDto {
    private Integer orderId;
    private double totalPrice;
    private List<ProductErrorDto> productErrors;
}
