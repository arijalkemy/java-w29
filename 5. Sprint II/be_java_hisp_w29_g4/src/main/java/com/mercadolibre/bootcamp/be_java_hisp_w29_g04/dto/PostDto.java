package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 1,message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no puede estar vacía")
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate createdAt;

    @NotNull(message = "Debe incluir un producto")
    @Valid
    private ProductDto product;

    @NotNull(message = "El campo o puede estar vacío")
    private Integer category;

    @Max(value = 10_000_000,message = "El precio maximo por producto es de 10.000.000")
    @NotNull(message = "El campo no puede estar vacío")
    private Double price;
}
