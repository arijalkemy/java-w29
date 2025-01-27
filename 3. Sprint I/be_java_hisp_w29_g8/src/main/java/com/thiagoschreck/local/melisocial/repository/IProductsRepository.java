package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.product.Product;

public interface IProductsRepository {
	Product getById(Integer productId);

	Product save(Product product);
}
