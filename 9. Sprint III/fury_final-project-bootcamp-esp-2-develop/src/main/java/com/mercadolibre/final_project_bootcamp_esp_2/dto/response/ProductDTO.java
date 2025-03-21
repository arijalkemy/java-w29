package com.mercadolibre.final_project_bootcamp_esp_2.dto.response;

import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private Double unitaryPrice;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private ProductType type;

    public ProductDTO(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
