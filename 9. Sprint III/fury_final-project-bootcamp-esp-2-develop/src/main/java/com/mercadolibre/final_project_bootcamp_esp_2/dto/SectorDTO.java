package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorDTO {

    @JsonProperty("section_code")
    @NotNull
    private Integer sectionCode;

    @JsonProperty("warehouse_code")
    @NotNull
    private Integer warehouseCode;
}