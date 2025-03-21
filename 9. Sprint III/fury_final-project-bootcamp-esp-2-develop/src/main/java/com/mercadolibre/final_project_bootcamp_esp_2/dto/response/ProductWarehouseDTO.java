package com.mercadolibre.final_project_bootcamp_esp_2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWarehouseDTO {

    private int product_id;
    private List<WarehouseStockDto> warehouses;

}