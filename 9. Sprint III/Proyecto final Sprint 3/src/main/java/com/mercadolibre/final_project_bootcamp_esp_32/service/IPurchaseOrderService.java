package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.PurchaseOrderRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductsPurchaseOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.PurchaseOrderResponseDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.PurchasedProductsByDateRangeDto;
import jakarta.servlet.http.HttpServletRequest;

public interface IPurchaseOrderService {
    PurchaseOrderResponseDto createPurchaseOrder(PurchaseOrderRequestDto order);

    PurchaseOrderResponseDto updatePurchaseOrder(Integer idOrder, PurchaseOrderRequestDto updatedOrder);

    ProductsPurchaseOrderDto listProductsByPurchaseOrder(Integer idOrder);

    PurchasedProductsByDateRangeDto searchPurchasedProductsByDateRange(HttpServletRequest httpServletRequest);
}
