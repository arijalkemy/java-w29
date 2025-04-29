package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductWarehouseResponseDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ResponseProductDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface IProductService {
    ResponseProductDTO selectMethod(String category);

    ProductWarehouseResponseDto searchProductsByWarehouse(Integer idProduct, HttpServletRequest httpServletRequest);
}