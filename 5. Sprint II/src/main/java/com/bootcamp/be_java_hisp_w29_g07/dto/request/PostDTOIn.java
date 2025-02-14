package com.bootcamp.be_java_hisp_w29_g07.dto.request;

import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationMessages;
import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import com.bootcamp.be_java_hisp_w29_g07.entity.Product;
import com.bootcamp.be_java_hisp_w29_g07.validation.ValidID;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTOIn {

    @ValidID
    private Integer user_id;

    /**
     * The date when the post was created.
     * This field stores the date of the post, formatted as "dd-MM-yyyy".
     */
    @JsonFormat(pattern = ValidationValues.DATE_PATTERN)
    @NotNull(message = ValidationMessages.DATE_CANNOT_BE_EMPTY)
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

}
