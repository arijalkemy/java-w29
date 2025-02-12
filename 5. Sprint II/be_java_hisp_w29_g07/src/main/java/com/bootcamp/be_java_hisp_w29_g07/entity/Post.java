package com.bootcamp.be_java_hisp_w29_g07.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * This class represents a post made by a seller about a product.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    /**
     * The unique identifier for the post.
     */
    @JsonProperty("post_id")
    private Integer id;
    /**
     * The ID of the user who created the post.
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * The date when the post was created.
     * This field stores the date of the post, formatted as "dd-MM-yyyy".
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    /**
     * The product associated with the post.
     */
    private Product product;
    /**
     * The category ID of the product.
     */
    private Integer category;
    /**
     * The price of the product.
     */
    private Double price;
    /**
     * Indicates whether the post has a promotion.
     */
    @JsonProperty("has_promo")
    private Boolean hasPromo = false;
    /**
     * The discount applied to the product.
     */
    private Double discount = 0.0;
}
