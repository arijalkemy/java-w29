package com.app.model;

import java.time.LocalDate;

public class Post {

    private Integer id;
    private Integer userId; //
    private Integer productId;
    private Integer category;
    private Double price;
    private LocalDate date;
    private Boolean hasPromo;
    private Double discount;

    public Post(Integer id, Integer userId, Integer productId, Integer category, Double price, LocalDate date, Boolean hasPromo, Double discount) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.date = date;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
