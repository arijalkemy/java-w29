package com.bootcamp.be_java_hisp_w29_g3.dto.request;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class PostRequestDto {
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer userId;

    @NotNull(message = "El campo no puede estar vacío.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductRequestDto product;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000", message = "El precio máximo permitido es 10,000,000.")
    private Double price;

    @JsonAlias(value = {"has_prom", "has_promo"})
    private Boolean hasProm = false;

    private Double discount;
}
