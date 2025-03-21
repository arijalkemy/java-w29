package com.mercadolibre.final_project_bootcamp_esp_2.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {

    @JsonProperty("status_code")
    private String statusCode = "CART";

}

