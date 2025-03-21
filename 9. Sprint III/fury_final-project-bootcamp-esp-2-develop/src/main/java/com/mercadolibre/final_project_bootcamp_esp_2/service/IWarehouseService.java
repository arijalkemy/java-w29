package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchSortType;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;

public interface IWarehouseService {
    ProductBatchListResponse getProductBatchesByProductIdSortedBy(Long supervisorId, Long productId, BatchSortType sortType);

}
