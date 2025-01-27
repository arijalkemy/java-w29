package com.bootcamp.be_java_hisp_w29_g07.dto.request;

import com.bootcamp.be_java_hisp_w29_g07.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents a Post with discount from a seller
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTOIn{
    /**
     * The unique identifier for the post.
     */
    private Integer user_id;
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
    private Boolean has_promo;
    /**
     * The discount applied to the product.
     */
    private Double discount;
}
