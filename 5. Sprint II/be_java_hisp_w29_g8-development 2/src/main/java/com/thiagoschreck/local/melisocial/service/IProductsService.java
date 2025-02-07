package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.dto.request.CreateProductDTO;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsResponseDTO;

public interface IProductsService {
	CreateProductDTO save(CreateProductDTO productDto);

	PromoPostsResponseDTO getAllPromoPostsFromSeller(Integer sellerId);
}
