package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductBatchStockDto {
    private Integer productId;
    private SectionDto section;
    private List<BatchStockDto> batchStock;
}
