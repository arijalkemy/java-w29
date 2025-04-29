package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BatchDueDateDTO {
    private Integer batchNumber;
    private Integer productId;
    private Integer productTypeId;
    private Integer currentQuantity;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

}
