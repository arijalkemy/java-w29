package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SectionInfo(
        @JsonProperty(value = "section_code")
        Long sectionCode,
        @JsonProperty(value = "warehouse_code")
        Long warehouseCode
) {
}
