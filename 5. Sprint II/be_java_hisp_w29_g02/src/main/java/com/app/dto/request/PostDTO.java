package com.app.dto.request;

import com.app.util.ValidationMessages;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//US 0005 US 0010
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    //@NotNull(message = ValidationMessages.VALIDATION_POST_ID_NOT_NULL)
    @Min(value = 1, message = ValidationMessages.VALIDATION_POST_ID_MIN)
    private Integer post_id;

    @NotNull(message = ValidationMessages.VALIDATION_USER_ID_NOT_NULL)
    @Min(value = 1, message = ValidationMessages.VALIDATION_USER_ID_MIN)
    private Integer user_id;

    @NotBlank(message = ValidationMessages.VALIDATION_DATE_NOT_BLANK)
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$", message = ValidationMessages.VALIDATION_DATE_PATTERN)
    private String date;

    @NotNull(message = ValidationMessages.VALIDATION_PRODUCT_NOT_NULL)
    private ProductDTO product;

    @Min(value = 1, message = ValidationMessages.VALIDATION_CATEGORY_MIN)
    private Integer category;

    @DecimalMax(value = "10000000", message = ValidationMessages.VALIDATION_PRICE_MAX)
    private Double price;

    @NotNull(message = ValidationMessages.VALIDATION_FIELD_NOT_NULL)
    private Boolean has_promo;

    @DecimalMin(value = "0.0", inclusive = true, message = ValidationMessages.VALIDATION_DISCOUNT_MIN)
    @DecimalMax(value = "0.99", inclusive = true, message = ValidationMessages.VALIDATION_DISCOUNT_MAX)
    private Double discount;

    @AssertTrue(message = ValidationMessages.VALIDATION_PROMO_DISCOUNT)
    public boolean isDiscountValid() {
        return (has_promo == null || !has_promo) || (discount != null && discount > 0.0);
    }

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

}