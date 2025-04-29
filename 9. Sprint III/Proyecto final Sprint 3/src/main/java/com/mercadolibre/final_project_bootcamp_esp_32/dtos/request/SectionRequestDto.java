package com.mercadolibre.final_project_bootcamp_esp_32.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class SectionRequestDto {
    @NotNull(message = "El codigo de seccion no puede estar vacio.")
    private Integer sectionCode;
    @NotNull(message = "El warehouse no puede estar vacío.")
    private Integer warehouseCode;
}
