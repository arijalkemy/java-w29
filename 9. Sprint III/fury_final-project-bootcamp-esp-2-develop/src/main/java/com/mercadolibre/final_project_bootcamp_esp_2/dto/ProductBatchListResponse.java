package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProductBatchListResponse(
        SectionInfo section,
        @JsonProperty(value = "product_id")
        Long productId,
        @JsonProperty(value = "batch_stock")
        List<BatchInfo> batchStock
) {
}
