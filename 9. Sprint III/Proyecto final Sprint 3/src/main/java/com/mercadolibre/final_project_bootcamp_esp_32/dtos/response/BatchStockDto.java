package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockDto {
    private Integer batchNumber;
    private Integer currentQuantity;
    private LocalDate dueDate;
}
