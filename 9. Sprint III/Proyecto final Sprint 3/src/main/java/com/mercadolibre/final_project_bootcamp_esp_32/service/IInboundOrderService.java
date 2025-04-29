package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.InboundOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchDto;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface IInboundOrderService {
    List<ProductBatchDto> saveInboundOrderBatchStock(InboundOrderDto order, HttpServletRequest request);
    List<ProductBatchDto> modifyInboundOrderBatchStock(InboundOrderDto order);
}
