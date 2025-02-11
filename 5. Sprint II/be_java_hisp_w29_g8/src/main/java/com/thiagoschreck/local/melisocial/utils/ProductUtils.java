package com.thiagoschreck.local.melisocial.utils;

import com.thiagoschreck.local.melisocial.dto.request.CreateProductDTO;
import com.thiagoschreck.local.melisocial.entity.product.Product;

public final class ProductUtils {

    private ProductUtils() {
    }

    public static Product mapProductDtoToProduct(CreateProductDTO productDto) {
        return new Product(productDto.id(), productDto.name(), productDto.type(), productDto.brand(),
                productDto.color(), productDto.notes());
    }
}
