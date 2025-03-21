package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMostOrdererDto {
    private Integer idProduct;
    private String name;
    private Long quantity;
}
