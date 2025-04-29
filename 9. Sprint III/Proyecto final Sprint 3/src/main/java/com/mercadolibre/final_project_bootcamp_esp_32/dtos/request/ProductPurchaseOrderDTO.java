package com.mercadolibre.final_project_bootcamp_esp_32.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
public class ProductPurchaseOrderDTO {
    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El codigo de producto debe ser mayor a 0.")
    @JsonProperty("product_id")
    private Integer productId;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer quantity;
}
