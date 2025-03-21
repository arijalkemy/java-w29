package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductErrorDto {
    private Integer productId;
    private String productName;
    private String errorMessage;

}
