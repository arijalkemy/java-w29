package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    @JsonProperty("product_id")
    private Integer id;

    @JsonProperty("product_name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("notes")
    private String notes;
}
