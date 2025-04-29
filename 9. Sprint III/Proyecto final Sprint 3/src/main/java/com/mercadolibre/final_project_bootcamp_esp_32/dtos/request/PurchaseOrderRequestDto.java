package com.mercadolibre.final_project_bootcamp_esp_32.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.StatusOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Valid
public class PurchaseOrderRequestDto {
    @NotNull(message = "La fecha no puede estar vacia.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @NotNull(message = "El id de comprador no debe estar vacio.")
    private Integer buyerId;
    @NotNull(message = "El estado de la orden no puede estar vacio.")
    private StatusOrder status;
    @NotNull(message = "La lista de productos no debe estar vacia")
    private List<@Valid ProductPurchaseOrderDTO> products;
}
