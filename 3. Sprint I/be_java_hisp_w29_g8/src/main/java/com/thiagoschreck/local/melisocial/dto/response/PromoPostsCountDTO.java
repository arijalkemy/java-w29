package com.thiagoschreck.local.melisocial.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PromoPostsCountDTO(
	@JsonProperty("user_id") int userId,
	@JsonProperty("user_name") String userName,
	@JsonProperty("promo_products_count") Long posts) {}
