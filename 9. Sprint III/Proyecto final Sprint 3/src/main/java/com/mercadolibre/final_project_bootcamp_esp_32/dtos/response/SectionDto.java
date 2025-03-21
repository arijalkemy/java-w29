package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionDto {
    private Integer sectionCode;
    private Integer warehouseCode;
}
