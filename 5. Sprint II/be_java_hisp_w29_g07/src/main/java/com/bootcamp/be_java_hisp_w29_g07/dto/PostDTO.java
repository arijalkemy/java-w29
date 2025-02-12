package com.bootcamp.be_java_hisp_w29_g07.dto;

import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import com.bootcamp.be_java_hisp_w29_g07.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents a Post from a seller
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//TODO: DELETE CLASS WHEN PostDTOIn and PostDTOOut be fully implemented
public class PostDTO {
    /**
     * The unique identifier for the post.
     */
    private Integer post_id;

    /**
     * The ID of the user who created the post.
     */
    private Integer user_id;

    /**
     * The date when the post was created.
     * This field stores the date of the post, formatted as "dd-MM-yyyy".
     */
    @JsonFormat(pattern = ValidationValues.DATE_PATTERN)
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
    private Boolean has_promo = false;

    /**
     * The discount applied to the product.
     */
    private Double discount = 0.0;
}
