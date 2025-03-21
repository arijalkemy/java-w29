package com.mercadolibre.final_project_bootcamp_esp_2.dto.response;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockListDTO {
    private List<BatchDTO> batch_stock;
}
