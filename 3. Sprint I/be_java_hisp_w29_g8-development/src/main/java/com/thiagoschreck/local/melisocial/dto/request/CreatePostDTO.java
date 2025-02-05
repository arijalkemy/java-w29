package com.thiagoschreck.local.melisocial.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CreatePostDTO(
	@JsonProperty("user_id") Integer userId,
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate date,
	@JsonProperty("product") CreateProductDTO productDto,
	int category,
	double price,
	@JsonProperty("has_promo") boolean hasPromo,
	double discount
) {}