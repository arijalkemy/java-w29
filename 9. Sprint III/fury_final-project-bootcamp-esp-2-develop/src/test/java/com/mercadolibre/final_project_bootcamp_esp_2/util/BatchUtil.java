package com.mercadolibre.final_project_bootcamp_esp_2.util;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.InboundOrderDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.SectorDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.BatchRequestDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BatchUtil {

    public static BatchRequestDto createBodyRequest() {
        LocalDate manufacturingDate = LocalDate.of(2025, 3, 14);
        LocalDateTime manufacturingDateTime = LocalDateTime.of(2025, 3, 15, 14, 0, 0);
        LocalDate dueDate = LocalDate.of(2025, 4, 14);
        List<BatchStockDTO> batchStockDto = List.of(new BatchStockDTO(324512, 2, 5.2, 0.5, 5, 5, manufacturingDate, manufacturingDateTime, dueDate));
        SectorDTO sectorDTO = new SectorDTO(2, 2);
        InboundOrderDTO inboundOrder = new InboundOrderDTO(1, "15/02/2025", sectorDTO, batchStockDto);
        return new BatchRequestDto(inboundOrder);
    }
}
