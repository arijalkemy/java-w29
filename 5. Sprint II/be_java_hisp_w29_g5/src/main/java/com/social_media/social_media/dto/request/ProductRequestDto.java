package com.social_media.social_media.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProductRequestDto {
    @NotNull(message = "La id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Long product_id;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String product_name;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}