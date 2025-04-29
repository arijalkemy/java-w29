package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.BatchStockDueDateDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchStockDto;
import jakarta.servlet.http.HttpServletRequest;

public interface IBatchService {

    BatchStockDueDateDTO getBatchStock(Integer cantDays, HttpServletRequest httpServletRequest,String order, String type);
    ProductBatchStockDto searchFreshProducts(Integer productId, String order, HttpServletRequest httpServletRequest);
}
