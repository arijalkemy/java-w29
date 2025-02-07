package com.thiagoschreck.local.melisocial.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record CreatePostDTO(
    @Positive(message = "El user_id debe ser mayor a cero")
	@JsonProperty("user_id") Integer userId,

    @NotNull(message = "La fecha no puede estar vacía")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate date,

    @Valid
	@JsonProperty("product") CreateProductDTO productDto,

    @PositiveOrZero
	int category,

    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
	double price,

	@JsonProperty("has_promo") boolean hasPromo,

	double discount
) {}