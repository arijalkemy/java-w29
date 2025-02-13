package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    @NotNull(message = "La id no puede estar vacía")
    @Min(value = 1,message = "El id debe ser mayor a cero")
    @JsonProperty("product_id")
    private Integer id;


    @NotNull(message = "El campo no puede estar vacío")
    @Size(max = 40,message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_.\\-\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String name;

    @NotNull(message = "El campo no puede estar vacío")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_.\\-\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("type")
    private String type;


    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 25,message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_.\\-\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("brand")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9&_.\\-\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("color")
    private String color;

    @Size(max = 80,message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_.\\-\\s]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("notes")
    private String notes;
}
