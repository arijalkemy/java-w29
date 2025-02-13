package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private static Integer idCount = 0;

    private Integer id;
    private Integer userId;
    private Product product;
    private LocalDate createdAt;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;


    /** Post Constructor with promo */
    public Post(Integer userId, Product product, LocalDate createdAt, Integer category, Double price, Boolean hasPromo, Double discount) {
        id = idCount++;
        this.userId = userId;
        this.product = product;
        this.createdAt = createdAt;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    /** Post Constructor without promo
     * @value hasPromo, set to false
     * @value discount, set to 0.0
     */
    public Post(Integer userId, Product product, LocalDate createdAt, Integer category, Double price) {
        this.id = idCount++;
        this.userId = userId;
        this.product = product;
        this.createdAt = createdAt;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }

    /** Calculates the price with the optional discount */
    public Double getPrice(){
        return hasPromo ? price - (price * discount) : price;
    }
}
