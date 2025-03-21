package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchSortType;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;

public interface IFreshProductService {
    ProductBatchListResponse findProductBatchList(Long productId, BatchSortType sortType);
}
