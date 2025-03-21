package com.mercadolibre.final_project_bootcamp_esp_2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseStockDto {

    public int warehouse_code;
    public int total_quantity;

}
