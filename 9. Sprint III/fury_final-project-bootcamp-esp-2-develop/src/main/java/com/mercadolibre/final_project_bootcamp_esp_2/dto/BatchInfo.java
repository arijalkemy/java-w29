package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record BatchInfo(
        @JsonProperty(value = "batch_number")
        int batchNumber,
        @JsonProperty(value = "current_quantity")
        int currentQuantity,
        @JsonProperty(value = "due_date")
        LocalDate date
) {
}
