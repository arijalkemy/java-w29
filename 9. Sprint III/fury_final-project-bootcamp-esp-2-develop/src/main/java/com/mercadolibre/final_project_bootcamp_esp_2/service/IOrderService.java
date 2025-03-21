package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.AddToCartResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Product;

import java.util.List;

public interface IOrderService {
    List<Product> getProductsByWarehouse(Long warehouseId, Long productId);
    List<ProductStockDTO> getProductStockByWarehouse(Long warehouseId, Long productId);
    List<ProductDTO> searchProductsInOrder(Long orderId);
    AddToCartResponseDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderRequestDTO);
    PurchaseOrderRequestDTO updateOrderById(Long orderId, PurchaseOrderRequestDTO dto);
}

