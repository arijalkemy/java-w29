package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class ProductBatchDto {
    @NotNull(message = "El batchNumber no puede estar vacio.")
    private Integer batchNumber;
    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El codigo de producto debe ser mayor a 0.")
    private Integer productId;
    @NotNull(message = "El valor actual de temperatura no puede estar vacio.")
    private Double currentTemperature;
    @NotNull(message = "El valor minimo de temperatura no puede estar vacio.")
    private Double minimumTemperature;
    @NotNull(message = "La cantidad inicial no puede estar vacia.")
    private Integer initialQuantity;
    @NotNull(message = "La cantidad actual no puede estar vacia.")
    private Integer currentQuantity;
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufacturingDate;
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingTime;
    @NotNull(message = "El campo no puede estar vacío.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
}
