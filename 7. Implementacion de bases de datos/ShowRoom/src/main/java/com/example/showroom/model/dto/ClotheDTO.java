package com.example.showroom.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ClotheDTO {
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    @JsonProperty("purchase_price")
    private Double salePrice;
}
