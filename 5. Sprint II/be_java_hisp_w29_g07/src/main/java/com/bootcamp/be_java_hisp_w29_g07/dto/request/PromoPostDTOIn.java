package com.bootcamp.be_java_hisp_w29_g07.dto.request;

import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationMessages;
import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import com.bootcamp.be_java_hisp_w29_g07.validation.ValidID;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @ValidID
    private Integer user_id;
    /**
     * The date when the post was created.
     * This field stores the date of the post, formatted as "dd-MM-yyyy".
     */
    @JsonFormat(pattern = ValidationValues.DATE_PATTERN)
    @NotNull(message= ValidationMessages.DATE_CANNOT_BE_EMPTY)
    private LocalDate date;
    /**
     * The product associated with the post.
     */
    @Valid
    private ProductDTO product;
    /**
     * The category ID of the product.
     */
    @NotNull(message= ValidationMessages.FIELD_CANNOT_BE_EMPTY)
    private Integer category;
    /**
     * The price of the product.
     */
    @NotNull(message = ValidationMessages.FIELD_CANNOT_BE_EMPTY)
    @Max(
            value = ValidationValues.MAX_PRODUCT_PRICE,
            message = ValidationMessages.MAX_PRODUCT_PRICE_MUST_BE)
    private Double price;

    /**
     * Indicates whether the post has a promotion.
     */
    @NotNull(message= ValidationMessages.FIELD_CANNOT_BE_NULL)
    private Boolean has_promo;

    /**
     * The discount applied to the product.
     */
    @NotNull(message = ValidationMessages.FIELD_CANNOT_BE_NULL)
    @Min(value = ValidationValues.MIN_PRODUCT_DISCOUNT, message = ValidationMessages.MIN_PRODUCT_DISCOUNT_MUST_BE)
    private Double discount;
}
