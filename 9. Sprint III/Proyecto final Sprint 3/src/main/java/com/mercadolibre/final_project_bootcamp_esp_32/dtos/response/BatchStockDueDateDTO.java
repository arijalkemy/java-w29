package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BatchStockDueDateDTO {
    List<BatchDueDateDTO> batchStock;
}
