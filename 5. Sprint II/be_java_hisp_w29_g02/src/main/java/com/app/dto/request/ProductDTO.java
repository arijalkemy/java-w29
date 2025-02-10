package com.app.dto.request;

import com.app.util.ValidationMessages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotNull(message = ValidationMessages.VALIDATION_PRODUCT_ID_NOT_NULL)
    @Min(value = 1, message = ValidationMessages.VALIDATION_PRODUCT_ID_MIN)
    private Integer product_id;

    @Size(max = 40, message = ValidationMessages.VALIDATION_PRODUCT_NAME_SIZE)
    @NotBlank(message = ValidationMessages.VALIDATION_PRODUCT_NAME_NOT_BLANK)
    private String product_name;

    @Size(max = 15, message = ValidationMessages.VALIDATION_PRODUCT_TYPE_SIZE)
    @NotBlank(message = ValidationMessages.VALIDATION_PRODUCT_TYPE_NOT_BLANK)
    private String type;

    @Size(max = 25, message = ValidationMessages.VALIDATION_PRODUCT_BRAND_SIZE)
    @NotBlank(message = ValidationMessages.VALIDATION_PRODUCT_BRAND_NOT_BLANK)
    private String brand;

    @Size(max = 15, message = ValidationMessages.VALIDATION_PRODUCT_COLOR_SIZE)
    @NotBlank(message = ValidationMessages.VALIDATION_PRODUCT_COLOR_NOT_BLANK)
    private String color;

    @Size(max = 80, message = ValidationMessages.VALIDATION_PRODUCT_NOTES_SIZE)
    @NotBlank(message = ValidationMessages.VALIDATION_PRODUCT_NOTES_NOT_BLANK)
    private String notes;

}
