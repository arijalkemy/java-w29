package com.bootcamp.be_java_hisp_w29_g07.dto.request;

import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import com.bootcamp.be_java_hisp_w29_g07.validation.ValidID;
import com.bootcamp.be_java_hisp_w29_g07.validation.ValidStringField;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    /**
     * The unique identifier for the product.
     */
    @ValidID
    @JsonProperty("product_id")
    private Integer id;

    /**
     * The name of the product.
     */
    @JsonProperty("product_name")
    @Size(max=ValidationValues.MAX_PRODUCT_NAME_LENGTH)
    @ValidStringField
    private String name;

    /**
     * The type of the product.
     */
    @Size(max=ValidationValues.MAX_PRODUCT_TYPE_LENGTH)
    @ValidStringField
    private String type;

    /**
     * The brand of the product.
     */
    @ValidStringField
    @Size(max=ValidationValues.MAX_PRODUCT_BRAND_LENGTH)
    private String brand;
    /**
     * The color of the product.
     */
    @ValidStringField
    @Size(max=ValidationValues.MAX_PRODUCT_COLOR_LENGTH)
    private String color;

    /**
     * Additional notes or description for the product.
     */
    @Size(max=ValidationValues.MAX_PRODUCT_NOTES_LENGTH)
    @ValidStringField
    private String notes;
}
