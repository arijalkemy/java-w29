package com.thiagoschreck.local.melisocial.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateProductDTO(
	@Positive(message = "El product_id debe ser mayor a cero")
	@JsonProperty("product_id") Integer id,

	@NotBlank(message = "El campo product_name no puede estar vacío")
	@Size(max = 40, message = "La longitud de product_name no puede superar los 40 caracteres")
	@JsonProperty("product_name") String name,

	@NotBlank(message = "El campo type no puede estar vacío")
	@Size(max = 15, message = "La longitud de type no puede superar los 15 caracteres")
	String type,

	@NotBlank(message = "El campo brand no puede estar vacío")
	@Size(max = 25, message = "La longitud de brand no puede superar los 25 caracteres")
	String brand,

	@NotBlank(message = "El campo color no puede estar vacío")
	@Size(max = 15, message = "La longitud de color no puede superar los 15 caracteres")
	String color,

	@Size(max = 80, message = "La longitud de notes no puede superar los 80 caracteres")
	String notes
) {}
