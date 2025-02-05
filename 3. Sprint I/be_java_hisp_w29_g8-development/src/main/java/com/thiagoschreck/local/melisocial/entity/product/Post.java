package com.thiagoschreck.local.melisocial.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Post {
	private final int id;
	private final Integer userId;
	private final LocalDate date;
	private final Product product;
	private final int category;
	private final double price;
	private final boolean onPromotion;
	private final double discount;
}