package com.app.dto.response;

import com.app.dto.request.ProductDTO;

import java.time.LocalDate;

public class PostsWithProductDTO {
    private final Integer user_id;
    private final Integer post_id;
    private final LocalDate date;
    private final ProductDTO product;
    private final Integer category;
    private final Double price;
    private final boolean has_promo;
    private final Double discount;

    public PostsWithProductDTO(Integer user_id, Integer post_id, LocalDate date, ProductDTO product, Integer category, Double price, boolean has_promo, Double discount) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public Integer getCategory() {
        return category;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isHas_promo() {
        return has_promo;
    }
}
