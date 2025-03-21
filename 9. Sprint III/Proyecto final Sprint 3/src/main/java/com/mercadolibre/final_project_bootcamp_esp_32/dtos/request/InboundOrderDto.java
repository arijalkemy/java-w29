package com.mercadolibre.final_project_bootcamp_esp_32.dtos.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class InboundOrderDto {
    @NotNull(message = "El numero de orden no puede estar vacio.")
    @Positive(message = "El numero de orden debe ser mayor a 0")
    private Integer orderNumber;
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    @Valid
    private SectionRequestDto section;
    private List<@Valid ProductBatchDto> batchStock;
}
