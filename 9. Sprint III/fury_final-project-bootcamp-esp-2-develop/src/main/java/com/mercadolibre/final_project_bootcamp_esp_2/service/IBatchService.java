package com.mercadolibre.final_project_bootcamp_esp_2.service;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.BatchRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockListDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;

public interface IBatchService {
    BatchStockResponseDTO createInboundOrder(BatchRequestDto batchRequestDto);

    BatchStockResponseDTO updateInboundOrder(BatchRequestDto batchRequestDto);

    /**
     * Provides all batches that are about to expire between today and the specified number of days ahead,
     * If specified, batches are ordered by due date, belonging to a specific product category.
     *
     * @param cantDays the maximum number of days from today that a batch's expiration date can be.
     * @param category the type of product of every batch.
     * @param dateOrder due date ordering.
     * @return a BatchStockDTO.
     * @throws BadRequestException if the request params have an invalid value.
     */
    BatchStockListDTO searchBatchStockByDueDate(Integer cantDays, String category, String dateOrder);
}
