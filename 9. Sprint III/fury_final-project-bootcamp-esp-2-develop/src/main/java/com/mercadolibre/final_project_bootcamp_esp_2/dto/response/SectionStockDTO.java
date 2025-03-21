package com.mercadolibre.final_project_bootcamp_esp_2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SectionStockDTO {
    private Long sectionId;
    private Integer quantity;
}
