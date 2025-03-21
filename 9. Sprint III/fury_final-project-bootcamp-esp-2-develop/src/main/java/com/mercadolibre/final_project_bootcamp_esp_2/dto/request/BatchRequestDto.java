package com.mercadolibre.final_project_bootcamp_esp_2.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.InboundOrderDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchRequestDto {
    @JsonProperty("inbound_order")
    @NotNull
    private InboundOrderDTO inboundOrder;
}