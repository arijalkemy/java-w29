package com.thiagoschreck.local.melisocial.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateProductDTO(
	@JsonProperty("product_id") Integer id,
	@JsonProperty("product_name") String name,
	String type,
	String brand,
	String color,
	String notes
) {}
