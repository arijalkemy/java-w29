package com.bootcamp.be_java_hisp_w29_g3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
