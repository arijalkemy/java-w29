package com.mercadolibre.final_project_bootcamp_esp_2.dto.response;

import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockAndSectionDTO {
    private Long warehouseId;
    private Long productId;
    private ProductType productType;
    private List<SectionStockDTO> sections;
}
