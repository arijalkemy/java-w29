package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.ProductDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PromoPostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Product;

public class PostMapper {
    public static Post dtoToPost(PostDto p) {
        return new Post(p.getUserId(), dtoToProduct(p.getProduct()), p.getCreatedAt(), p.getCategory(), p.getPrice());
    }

    public static Post dtoToPost(PromoPostDto p) {
        return new Post(p.getUserId(), dtoToProduct(p.getProduct()), p.getCreatedAt(), p.getCategory(), p.getPrice(), p.getHasPromo(), p.getDiscount());
    }

    public static PostDto postToDto(Post p) {
        return new PostDto(p.getUserId(), p.getCreatedAt(), productToDto(p.getProduct()), p.getCategory(), p.getPrice());
    }

    public static PromoPostDto postToPromoDto(Post p) {
        return new PromoPostDto(p.getUserId(), p.getCreatedAt(), productToDto(p.getProduct()), p.getCategory(), p.getPrice(), p.getHasPromo(), p.getDiscount());
    }

    private static ProductDto productToDto(Product p) {
        return new ProductDto(p.getId(), p.getName(), p.getType(), p.getBrand(), p.getColor(), p.getNotes());
    }

    private static Product dtoToProduct (ProductDto p) {
        return new Product(p.getId(), p.getName(),p.getType(), p.getBrand(), p.getColor(), p.getNotes());
    }
}
