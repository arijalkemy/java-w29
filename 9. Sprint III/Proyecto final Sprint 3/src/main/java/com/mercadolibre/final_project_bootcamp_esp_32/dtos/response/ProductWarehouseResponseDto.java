package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWarehouseResponseDto {
    private Integer productId;
    private List<WarehouseStockDto> warehouses;
}
