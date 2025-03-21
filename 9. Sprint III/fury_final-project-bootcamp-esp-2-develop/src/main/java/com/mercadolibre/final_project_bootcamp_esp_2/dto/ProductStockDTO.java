package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import lombok.*;

@Getter @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockDTO {
    private Long id;
    private String name;
    private Double unitaryPrice;
    private Integer quantity;
    private ProductType type;

}
