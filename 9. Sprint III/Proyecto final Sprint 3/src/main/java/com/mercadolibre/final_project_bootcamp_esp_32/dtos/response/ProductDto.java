package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productId;
    private SectionDto section;
    private BatchStockDto batchStock;
}
