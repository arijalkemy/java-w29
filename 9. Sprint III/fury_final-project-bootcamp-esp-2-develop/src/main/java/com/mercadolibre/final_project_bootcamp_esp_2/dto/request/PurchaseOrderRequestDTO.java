package com.mercadolibre.final_project_bootcamp_esp_2.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderRequestDTO {
    @JsonProperty("purchase_order")
    private OrderRequestDTO orderRequestDTO;
}
