package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    @NotNull
    @NotEmpty
    @Positive
    @JsonProperty("product_id")
    private Integer idProduct;

    private String name;

    @NotNull @NotEmpty @Positive
    @JsonProperty("quantity")
    private Integer quantity;
}
