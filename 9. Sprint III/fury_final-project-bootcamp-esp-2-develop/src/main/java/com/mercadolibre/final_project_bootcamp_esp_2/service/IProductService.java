package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductStockAndSectionDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductWarehouseDTO;

import java.util.List;

public interface IProductService {
    ProductWarehouseDTO searchProductStockInWarehouses(Long idProduct);
    List<ProductDTO> getProductsByType(String type);
    List<ProductStockDTO> getProductStockByWarehouse(Long warehouseId, Long productId);
    ProductStockAndSectionDTO getProductStockAndEachSectionByWarehouse(Long warehouseId, Long productId);

    }

