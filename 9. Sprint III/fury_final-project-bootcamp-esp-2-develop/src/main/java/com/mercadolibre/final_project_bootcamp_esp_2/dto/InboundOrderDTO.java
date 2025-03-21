package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderDTO {

    @JsonProperty("order_number")
    @NotNull
    private Integer orderNumber;

    @JsonProperty("order_date")
    @NotNull
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "El formato de fecha debe ser dd-MM-yyyy")
    private String orderDate;

    @JsonProperty("section")
    @NotNull
    private SectorDTO section;

    @JsonProperty("batch_stock")
    @NotNull
    private List<BatchStockDTO> batchStock;
}
