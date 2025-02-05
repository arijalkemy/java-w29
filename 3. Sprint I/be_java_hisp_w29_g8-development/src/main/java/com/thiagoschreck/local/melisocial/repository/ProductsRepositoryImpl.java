package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.product.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductsRepositoryImpl implements IProductsRepository {
	private Map<Integer, Product> products;

	public ProductsRepositoryImpl() {
		this.products = new HashMap<>();
	}

	@Override
	public Product getById(Integer productId) {
		return products.get(productId);
	}

	@Override
	public Product save(Product product) {
		products.put(product.getId(), product);
		return product;
	}
}
