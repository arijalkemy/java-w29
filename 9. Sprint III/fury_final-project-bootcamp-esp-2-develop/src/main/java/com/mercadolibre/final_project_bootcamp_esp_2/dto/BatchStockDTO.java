package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStockDTO {

    @JsonProperty("batch_number")
    @NotNull
    private Integer batchNumber;

    @JsonProperty("product_id")
    @NotNull
    private Integer productId;

    @JsonProperty("current_temperature")
    @NotNull
    private Double currentTemperature;

    @JsonProperty("minimum_temperature")
    @NotNull
    private Double minimumTemperature;

    @JsonProperty("initial_quantity")
    @NotNull
    private Integer initialQuantity;

    @JsonProperty("current_quantity")
    @NotNull
    private Integer currentQuantity;

    @JsonProperty("manufacturing_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate manufacturingDate;

    @JsonProperty("manufacturing_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingTime;

    @JsonProperty("due_date")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}