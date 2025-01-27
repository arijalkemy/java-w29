package com.app.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

//US 0005 US 0010
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PostDTO {
    private Integer post_id;
    private Integer user_id;
    private String date;
    private ProductDTO product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;


    public PostDTO(Integer post_id, Integer user_id, String date, ProductDTO product, Integer category, Double price) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public PostDTO(Integer user_id, String date, ProductDTO product, Integer category, Double price) {
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public PostDTO(Integer post_id, Integer user_id, String date, ProductDTO product, Integer category, Double price, Boolean has_promo, Double discount) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public PostDTO() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO productDTO) {
        this.product = productDTO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getHas_promo() {
        return has_promo;
    }

    public void setHas_promo(Boolean has_promo) {
        this.has_promo = has_promo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }
}